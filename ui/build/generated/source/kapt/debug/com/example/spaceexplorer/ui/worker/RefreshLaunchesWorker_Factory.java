package com.example.spaceexplorer.ui.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.example.spaceexplorer.data.repository.SpaceXRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class RefreshLaunchesWorker_Factory {
  private final Provider<SpaceXRepository> repositoryProvider;

  public RefreshLaunchesWorker_Factory(Provider<SpaceXRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public RefreshLaunchesWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, repositoryProvider.get());
  }

  public static RefreshLaunchesWorker_Factory create(
      Provider<SpaceXRepository> repositoryProvider) {
    return new RefreshLaunchesWorker_Factory(repositoryProvider);
  }

  public static RefreshLaunchesWorker newInstance(Context context, WorkerParameters params,
      SpaceXRepository repository) {
    return new RefreshLaunchesWorker(context, params, repository);
  }
}
