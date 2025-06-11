package com.example.spaceexplorer.di;

import com.example.spaceexplorer.data.local.LaunchDao;
import com.example.spaceexplorer.data.local.SpaceExplorerDatabase;
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
public final class AppModule_ProvideLaunchDaoFactory implements Factory<LaunchDao> {
  private final Provider<SpaceExplorerDatabase> databaseProvider;

  public AppModule_ProvideLaunchDaoFactory(Provider<SpaceExplorerDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public LaunchDao get() {
    return provideLaunchDao(databaseProvider.get());
  }

  public static AppModule_ProvideLaunchDaoFactory create(
      Provider<SpaceExplorerDatabase> databaseProvider) {
    return new AppModule_ProvideLaunchDaoFactory(databaseProvider);
  }

  public static LaunchDao provideLaunchDao(SpaceExplorerDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLaunchDao(database));
  }
}
