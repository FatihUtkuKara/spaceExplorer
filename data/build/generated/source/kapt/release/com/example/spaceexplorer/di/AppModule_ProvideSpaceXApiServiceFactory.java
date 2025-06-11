package com.example.spaceexplorer.di;

import com.example.spaceexplorer.data.api.SpaceXApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AppModule_ProvideSpaceXApiServiceFactory implements Factory<SpaceXApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideSpaceXApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public SpaceXApiService get() {
    return provideSpaceXApiService(retrofitProvider.get());
  }

  public static AppModule_ProvideSpaceXApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideSpaceXApiServiceFactory(retrofitProvider);
  }

  public static SpaceXApiService provideSpaceXApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSpaceXApiService(retrofit));
  }
}
