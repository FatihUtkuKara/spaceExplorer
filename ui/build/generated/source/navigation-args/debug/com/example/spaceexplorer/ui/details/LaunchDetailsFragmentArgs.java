package com.example.spaceexplorer.ui.details;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class LaunchDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private LaunchDetailsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private LaunchDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static LaunchDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    LaunchDetailsFragmentArgs __result = new LaunchDetailsFragmentArgs();
    bundle.setClassLoader(LaunchDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("launchId")) {
      String launchId;
      launchId = bundle.getString("launchId");
      if (launchId == null) {
        throw new IllegalArgumentException("Argument \"launchId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("launchId", launchId);
    } else {
      throw new IllegalArgumentException("Required argument \"launchId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static LaunchDetailsFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    LaunchDetailsFragmentArgs __result = new LaunchDetailsFragmentArgs();
    if (savedStateHandle.contains("launchId")) {
      String launchId;
      launchId = savedStateHandle.get("launchId");
      if (launchId == null) {
        throw new IllegalArgumentException("Argument \"launchId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("launchId", launchId);
    } else {
      throw new IllegalArgumentException("Required argument \"launchId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getLaunchId() {
    return (String) arguments.get("launchId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("launchId")) {
      String launchId = (String) arguments.get("launchId");
      __result.putString("launchId", launchId);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("launchId")) {
      String launchId = (String) arguments.get("launchId");
      __result.set("launchId", launchId);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    LaunchDetailsFragmentArgs that = (LaunchDetailsFragmentArgs) object;
    if (arguments.containsKey("launchId") != that.arguments.containsKey("launchId")) {
      return false;
    }
    if (getLaunchId() != null ? !getLaunchId().equals(that.getLaunchId()) : that.getLaunchId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getLaunchId() != null ? getLaunchId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "LaunchDetailsFragmentArgs{"
        + "launchId=" + getLaunchId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull LaunchDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String launchId) {
      if (launchId == null) {
        throw new IllegalArgumentException("Argument \"launchId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("launchId", launchId);
    }

    @NonNull
    public LaunchDetailsFragmentArgs build() {
      LaunchDetailsFragmentArgs result = new LaunchDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setLaunchId(@NonNull String launchId) {
      if (launchId == null) {
        throw new IllegalArgumentException("Argument \"launchId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("launchId", launchId);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getLaunchId() {
      return (String) arguments.get("launchId");
    }
  }
}
