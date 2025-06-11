package com.example.spaceexplorer.di;

import com.example.spaceexplorer.data.repository.SpaceXRepository;
import com.example.spaceexplorer.data.usecase.GetLaunchesUseCase;
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
public final class DataModule_ProvideGetLaunchesUseCaseFactory implements Factory<GetLaunchesUseCase> {
  private final Provider<SpaceXRepository> repositoryProvider;

  public DataModule_ProvideGetLaunchesUseCaseFactory(
      Provider<SpaceXRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetLaunchesUseCase get() {
    return provideGetLaunchesUseCase(repositoryProvider.get());
  }

  public static DataModule_ProvideGetLaunchesUseCaseFactory create(
      Provider<SpaceXRepository> repositoryProvider) {
    return new DataModule_ProvideGetLaunchesUseCaseFactory(repositoryProvider);
  }

  public static GetLaunchesUseCase provideGetLaunchesUseCase(SpaceXRepository repository) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideGetLaunchesUseCase(repository));
  }
}
