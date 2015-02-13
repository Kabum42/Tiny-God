package net.piropanda.tinygod.android;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.android.vending.billing.IInAppBillingService;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.plus.Plus;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TinyGod;
import net.piropanda.tinygod.GoogleInterface;

public class AndroidLauncher extends AndroidApplication implements GoogleInterface, ConnectionCallbacks, OnConnectionFailedListener {
	
	public GoogleApiClient  mGoogleApiClient;
	private static final int REQUEST_RESOLVE_ERROR = 1001;
	private static final String DIALOG_ERROR = "dialog_error";
	private static final String STATE_RESOLVING_ERROR = "resolving_error";
	private boolean mResolvingError = false;
	private boolean mSaving = false;
	
	private Snapshot snapshot;
	
	private IInAppBillingService mService;
	
	private TinyGod game = new TinyGod(this);
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
		serviceIntent.setPackage("com.android.vending");
		bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);
		
		mGoogleApiClient = new GoogleApiClient.Builder(this)
	    .addApi(Games.API).addScope(Games.SCOPE_GAMES)
	    .addApi(Drive.API).addScope(Drive.SCOPE_APPFOLDER)
	    .addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
	    .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
	    .build();
		
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(game, config);
		
		//startService(new Intent(this, ProduceBackground.class));

	}
	
	@Override
	public void login() {
		
		if (!mResolvingError) {  // more about this later
			//umg game.gsm.actualState.info = "LOGIN BEGAN";
            mGoogleApiClient.connect();
        }
		
	}
	
	@Override
	public boolean isConnected() {
		
		if (mGoogleApiClient.isConnected()) {
			//umg game.gsm.actualState.info = "CONNECTED";
			return true;
		}
		//umg game.gsm.actualState.info = "NOT CONNECTED";
		return false;
		
	}
	
	@Override
	public boolean isConnecting() {
		
		if (mGoogleApiClient.isConnecting()) {
			//umg game.gsm.actualState.info = "CONNECTING";
			return true;
		}
		return false;
		
	}
	
	@Override
	public void logout() {
		
		//umg game.gsm.actualState.info = "DISCONNECTED";
		mGoogleApiClient.disconnect();

	}
	
	@Override
	public void load(boolean changeGameInfo) {
		
		if (isConnected()) {
			
			Snapshots.OpenSnapshotResult result = Games.Snapshots.open(mGoogleApiClient, "currentSaveName", true).await();
			
			int status = result.getStatus().getStatusCode();
			
			if (status == GamesStatusCodes.STATUS_OK) {
				
	            snapshot = result.getSnapshot();
	            
	            if (changeGameInfo) {
	            	GameInfo.loadFromSnapshot(snapshot.readFully());
	            }
	            else {
	            	mSaving = false;
	            }
	            
	        }
			
		}
		
	}

	@Override
	public void save() {
        
		if (isConnected() && !mSaving) {
        	mSaving = true;
        	writeSnapshot(snapshot);
        }    
		
	}


	/** After unlocking the achievement on Google Servers it sets to true its value in the active SaveGame */
	@Override
	public void unlockAchievement(String achievement) {
		
		//umg game.gsm.actualState.info = "OTORGANDO LOGRO";
		// "CgkIwb-rs-IREAIQAQ"
		Games.Achievements.unlock(mGoogleApiClient, achievement);
		//umg mGameInfo.writeAchievement(achievement, true);
		
	}
	

	@Override
	public void onConnectionFailed(ConnectionResult result) {
        if (mResolvingError) {
            // Already attempting to resolve an error.
            return;
        } else if (result.hasResolution()) {
            try {
                mResolvingError = true;
                result.startResolutionForResult(this, REQUEST_RESOLVE_ERROR);
            } catch (SendIntentException e) {
                // There was an error with the resolution intent. Try again.
                mGoogleApiClient.connect();
            }
        } else {
        	//game.gsm.actualState.info = result.getErrorCode();
            mResolvingError = true;
        }
    }


	@Override
	public void onConnectionSuspended(int cause) {
        // The connection has been interrupted.
        // Disable any UI components that depend on Google APIs
        // until onConnected() is called.
    }

	
	/* Creates a dialog for an error message */
    private void showErrorDialog(int errorCode) {
        // Create a fragment for the error dialog
        ErrorDialogFragment dialogFragment = new ErrorDialogFragment();
        // Pass the error that should be displayed
        Bundle args = new Bundle();
        args.putInt(DIALOG_ERROR, errorCode);
        dialogFragment.setArguments(args);
        //  dialogFragment.show(null, "errordialog");
    }
    
    /* Called from ErrorDialogFragment when the dialog is dismissed. */
    public void onDialogDismissed() {
        mResolvingError = false;
    }

    /* A fragment to display an error dialog */
    public static class ErrorDialogFragment extends DialogFragment {
        public ErrorDialogFragment() { }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Get the error code and retrieve the appropriate dialog
            int errorCode = this.getArguments().getInt(DIALOG_ERROR);
            return GooglePlayServicesUtil.getErrorDialog(errorCode,
                    this.getActivity(), REQUEST_RESOLVE_ERROR);
        }

        @Override
        public void onDismiss(DialogInterface dialog) {
            ((AndroidLauncher) getActivity()).onDialogDismissed();
        }
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_RESOLVE_ERROR) {
            mResolvingError = false;
            if (resultCode == RESULT_OK) {
                // Make sure the app is not already connected or attempting to connect
                if (!mGoogleApiClient.isConnecting() &&
                        !mGoogleApiClient.isConnected()) {
                    mGoogleApiClient.connect();
                }
            }
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_RESOLVING_ERROR, mResolvingError);
    }
    
    
    ServiceConnection mServiceConn = new ServiceConnection() {
    	   @Override
    	   public void onServiceDisconnected(ComponentName name) {
    	       mService = null;
    	   }

    	   @Override
    	   public void onServiceConnected(ComponentName name, 
    	      IBinder service) {
    	       mService = IInAppBillingService.Stub.asInterface(service);
    	   }
    };
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mService != null) {
            unbindService(mServiceConn);
        }   
    }
    
    private void writeSnapshot(Snapshot snapshot) {
        // Set the data payload for the snapshot.
        snapshot.writeBytes(GameInfo.toBytes());

        // Save the snapshot.
        SnapshotMetadataChange metadataChange = new SnapshotMetadataChange.Builder()
                //.setCoverImage(getScreenShot())
                .setDescription("This should be a description, but it's not! Mwahaha")
                .build();
        Snapshots.CommitSnapshotResult result = Games.Snapshots.commitAndClose(mGoogleApiClient, snapshot, metadataChange).await();
       // Snapshots.CommitSnapshotResult
        
        int status = result.getStatus().getStatusCode();
		
		if (status == GamesStatusCodes.STATUS_OK) {
			
			load(false);
			
        }
        
        
        //return snapshot.toString();
    }
    
    @Override
	public void onBackPressed() {
		if (game.onBackPressed()) {
			moveTaskToBack(true);
		}
	}

	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

