package com.example.spaceexplorer.ui.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class RefreshLaunchesWorker_AssistedFactory_Impl implements RefreshLaunchesWorker_AssistedFactory {
  private final RefreshLaunchesWorker_Factory delegateFactory;

  RefreshLaunchesWorker_AssistedFactory_Impl(RefreshLaunchesWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public RefreshLaunchesWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<RefreshLaunchesWorker_AssistedFactory> create(
      RefreshLaunchesWorker_Factory delegateFactory) {
    return InstanceFactory.create(new RefreshLaunchesWorker_AssistedFactory_Impl(delegateFactory));
  }
}
