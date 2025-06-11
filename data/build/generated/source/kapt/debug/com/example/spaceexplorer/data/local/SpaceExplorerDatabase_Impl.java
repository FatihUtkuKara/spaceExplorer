package com.example.spaceexplorer.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SpaceExplorerDatabase_Impl extends SpaceExplorerDatabase {
  private volatile LaunchDao _launchDao;

  private volatile RocketDao _rocketDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `launches` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `dateUtc` INTEGER NOT NULL, `rocketId` TEXT NOT NULL, `success` INTEGER, `details` TEXT, `webcast` TEXT, `article` TEXT, `wikipedia` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `rockets` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `active` INTEGER NOT NULL, `company` TEXT NOT NULL, `costPerLaunch` INTEGER NOT NULL, `successRatePct` INTEGER NOT NULL, `firstFlight` TEXT, `country` TEXT NOT NULL, `wikipedia` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'eab10fcf8090b64b720520a47d95a289')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `launches`");
        db.execSQL("DROP TABLE IF EXISTS `rockets`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsLaunches = new HashMap<String, TableInfo.Column>(9);
        _columnsLaunches.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLaunches.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLaunches.put("dateUtc", new TableInfo.Column("dateUtc", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLaunches.put("rocketId", new TableInfo.Column("rocketId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLaunches.put("success", new TableInfo.Column("success", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLaunches.put("details", new TableInfo.Column("details", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLaunches.put("webcast", new TableInfo.Column("webcast", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLaunches.put("article", new TableInfo.Column("article", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLaunches.put("wikipedia", new TableInfo.Column("wikipedia", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLaunches = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLaunches = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLaunches = new TableInfo("launches", _columnsLaunches, _foreignKeysLaunches, _indicesLaunches);
        final TableInfo _existingLaunches = TableInfo.read(db, "launches");
        if (!_infoLaunches.equals(_existingLaunches)) {
          return new RoomOpenHelper.ValidationResult(false, "launches(com.example.spaceexplorer.data.model.SpaceLaunch).\n"
                  + " Expected:\n" + _infoLaunches + "\n"
                  + " Found:\n" + _existingLaunches);
        }
        final HashMap<String, TableInfo.Column> _columnsRockets = new HashMap<String, TableInfo.Column>(10);
        _columnsRockets.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("company", new TableInfo.Column("company", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("costPerLaunch", new TableInfo.Column("costPerLaunch", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("successRatePct", new TableInfo.Column("successRatePct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("firstFlight", new TableInfo.Column("firstFlight", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("country", new TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRockets.put("wikipedia", new TableInfo.Column("wikipedia", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRockets = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRockets = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRockets = new TableInfo("rockets", _columnsRockets, _foreignKeysRockets, _indicesRockets);
        final TableInfo _existingRockets = TableInfo.read(db, "rockets");
        if (!_infoRockets.equals(_existingRockets)) {
          return new RoomOpenHelper.ValidationResult(false, "rockets(com.example.spaceexplorer.data.model.Rocket).\n"
                  + " Expected:\n" + _infoRockets + "\n"
                  + " Found:\n" + _existingRockets);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "eab10fcf8090b64b720520a47d95a289", "52e4d29a54bb501d5425d8a8b0e2cf9d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "launches","rockets");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `launches`");
      _db.execSQL("DELETE FROM `rockets`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LaunchDao.class, LaunchDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RocketDao.class, RocketDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public LaunchDao launchDao() {
    if (_launchDao != null) {
      return _launchDao;
    } else {
      synchronized(this) {
        if(_launchDao == null) {
          _launchDao = new LaunchDao_Impl(this);
        }
        return _launchDao;
      }
    }
  }

  @Override
  public RocketDao rocketDao() {
    if (_rocketDao != null) {
      return _rocketDao;
    } else {
      synchronized(this) {
        if(_rocketDao == null) {
          _rocketDao = new RocketDao_Impl(this);
        }
        return _rocketDao;
      }
    }
  }
}
