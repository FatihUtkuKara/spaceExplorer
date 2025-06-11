package com.example.spaceexplorer.data.repository;

import com.example.spaceexplorer.data.api.SpaceXApiService;
import com.example.spaceexplorer.data.local.LaunchDao;
import com.example.spaceexplorer.data.local.RocketDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class SpaceXRepository_Factory implements Factory<SpaceXRepository> {
  private final Provider<SpaceXApiService> apiServiceProvider;

  private final Provider<LaunchDao> launchDaoProvider;

  private final Provider<RocketDao> rocketDaoProvider;

  public SpaceXRepository_Factory(Provider<SpaceXApiService> apiServiceProvider,
      Provider<LaunchDao> launchDaoProvider, Provider<RocketDao> rocketDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.launchDaoProvider = launchDaoProvider;
    this.rocketDaoProvider = rocketDaoProvider;
  }

  @Override
  public SpaceXRepository get() {
    return newInstance(apiServiceProvider.get(), launchDaoProvider.get(), rocketDaoProvider.get());
  }

  public static SpaceXRepository_Factory create(Provider<SpaceXApiService> apiServiceProvider,
      Provider<LaunchDao> launchDaoProvider, Provider<RocketDao> rocketDaoProvider) {
    return new SpaceXRepository_Factory(apiServiceProvider, launchDaoProvider, rocketDaoProvider);
  }

  public static SpaceXRepository newInstance(SpaceXApiService apiService, LaunchDao launchDao,
      RocketDao rocketDao) {
    return new SpaceXRepository(apiService, launchDao, rocketDao);
  }
}
