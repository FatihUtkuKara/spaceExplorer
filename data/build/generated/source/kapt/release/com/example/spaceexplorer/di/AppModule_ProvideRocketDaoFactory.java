package com.example.spaceexplorer.di;

import com.example.spaceexplorer.data.local.RocketDao;
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
public final class AppModule_ProvideRocketDaoFactory implements Factory<RocketDao> {
  private final Provider<SpaceExplorerDatabase> databaseProvider;

  public AppModule_ProvideRocketDaoFactory(Provider<SpaceExplorerDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public RocketDao get() {
    return provideRocketDao(databaseProvider.get());
  }

  public static AppModule_ProvideRocketDaoFactory create(
      Provider<SpaceExplorerDatabase> databaseProvider) {
    return new AppModule_ProvideRocketDaoFactory(databaseProvider);
  }

  public static RocketDao provideRocketDao(SpaceExplorerDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRocketDao(database));
  }
}
