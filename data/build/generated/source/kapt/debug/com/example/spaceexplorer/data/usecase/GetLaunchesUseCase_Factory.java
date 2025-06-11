package com.example.spaceexplorer.data.usecase;

import com.example.spaceexplorer.data.repository.SpaceXRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class GetLaunchesUseCase_Factory implements Factory<GetLaunchesUseCase> {
  private final Provider<SpaceXRepository> repositoryProvider;

  public GetLaunchesUseCase_Factory(Provider<SpaceXRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetLaunchesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetLaunchesUseCase_Factory create(Provider<SpaceXRepository> repositoryProvider) {
    return new GetLaunchesUseCase_Factory(repositoryProvider);
  }

  public static GetLaunchesUseCase newInstance(SpaceXRepository repository) {
    return new GetLaunchesUseCase(repository);
  }
}
