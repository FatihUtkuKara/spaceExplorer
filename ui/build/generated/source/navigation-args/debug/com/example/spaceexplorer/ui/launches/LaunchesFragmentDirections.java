package com.example.spaceexplorer.ui.launches;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.spaceexplorer.ui.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class LaunchesFragmentDirections {
  private LaunchesFragmentDirections() {
  }

  @NonNull
  public static ActionLaunchesToDetails actionLaunchesToDetails(@NonNull String launchId) {
    return new ActionLaunchesToDetails(launchId);
  }

  public static class ActionLaunchesToDetails implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionLaunchesToDetails(@NonNull String launchId) {
      if (launchId == null) {
        throw new IllegalArgumentException("Argument \"launchId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("launchId", launchId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionLaunchesToDetails setLaunchId(@NonNull String launchId) {
      if (launchId == null) {
        throw new IllegalArgumentException("Argument \"launchId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("launchId", launchId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("launchId")) {
        String launchId = (String) arguments.get("launchId");
        __result.putString("launchId", launchId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_launches_to_details;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getLaunchId() {
      return (String) arguments.get("launchId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionLaunchesToDetails that = (ActionLaunchesToDetails) object;
      if (arguments.containsKey("launchId") != that.arguments.containsKey("launchId")) {
        return false;
      }
      if (getLaunchId() != null ? !getLaunchId().equals(that.getLaunchId()) : that.getLaunchId() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getLaunchId() != null ? getLaunchId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionLaunchesToDetails(actionId=" + getActionId() + "){"
          + "launchId=" + getLaunchId()
          + "}";
    }
  }
}
