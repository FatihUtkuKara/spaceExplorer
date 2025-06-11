package com.example.spaceexplorer.di;

import com.example.spaceexplorer.data.repository.SpaceXRepository;
import com.example.spaceexplorer.data.usecase.RefreshLaunchesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DataModule_ProvideRefreshLaunchesUseCaseFactory implements Factory<RefreshLaunchesUseCase> {
  private final Provider<SpaceXRepository> repositoryProvider;

  public DataModule_ProvideRefreshLaunchesUseCaseFactory(
      Provider<SpaceXRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public RefreshLaunchesUseCase get() {
    return provideRefreshLaunchesUseCase(repositoryProvider.get());
  }

  public static DataModule_ProvideRefreshLaunchesUseCaseFactory create(
      Provider<SpaceXRepository> repositoryProvider) {
    return new DataModule_ProvideRefreshLaunchesUseCaseFactory(repositoryProvider);
  }

  public static RefreshLaunchesUseCase provideRefreshLaunchesUseCase(SpaceXRepository repository) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideRefreshLaunchesUseCase(repository));
  }
}
