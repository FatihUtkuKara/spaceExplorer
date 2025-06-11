package com.example.spaceexplorer.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.spaceexplorer.data.model.Links;
import com.example.spaceexplorer.data.model.SpaceLaunch;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LaunchDao_Impl implements LaunchDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SpaceLaunch> __insertionAdapterOfSpaceLaunch;

  private final Converters __converters = new Converters();

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllLaunches;

  public LaunchDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSpaceLaunch = new EntityInsertionAdapter<SpaceLaunch>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `launches` (`id`,`name`,`dateUtc`,`rocketId`,`success`,`details`,`webcast`,`article`,`wikipedia`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SpaceLaunch entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        final Long _tmp = __converters.dateToTimestamp(entity.getDateUtc());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, _tmp);
        }
        if (entity.getRocketId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getRocketId());
        }
        final Integer _tmp_1 = entity.getSuccess() == null ? null : (entity.getSuccess() ? 1 : 0);
        if (_tmp_1 == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp_1);
        }
        if (entity.getDetails() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDetails());
        }
        final Links _tmpLinks = entity.getLinks();
        if (_tmpLinks != null) {
          if (_tmpLinks.getWebcast() == null) {
            statement.bindNull(7);
          } else {
            statement.bindString(7, _tmpLinks.getWebcast());
          }
          if (_tmpLinks.getArticle() == null) {
            statement.bindNull(8);
          } else {
            statement.bindString(8, _tmpLinks.getArticle());
          }
          if (_tmpLinks.getWikipedia() == null) {
            statement.bindNull(9);
          } else {
            statement.bindString(9, _tmpLinks.getWikipedia());
          }
        } else {
          statement.bindNull(7);
          statement.bindNull(8);
          statement.bindNull(9);
        }
      }
    };
    this.__preparedStmtOfDeleteAllLaunches = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM launches";
        return _query;
      }
    };
  }

  @Override
  public Object insertLaunches(final List<SpaceLaunch> launches,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSpaceLaunch.insert(launches);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllLaunches(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllLaunches.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllLaunches.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<SpaceLaunch>> getAllLaunches() {
    final String _sql = "SELECT * FROM launches ORDER BY dateUtc DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"launches"}, new Callable<List<SpaceLaunch>>() {
      @Override
      @NonNull
      public List<SpaceLaunch> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDateUtc = CursorUtil.getColumnIndexOrThrow(_cursor, "dateUtc");
          final int _cursorIndexOfRocketId = CursorUtil.getColumnIndexOrThrow(_cursor, "rocketId");
          final int _cursorIndexOfSuccess = CursorUtil.getColumnIndexOrThrow(_cursor, "success");
          final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
          final int _cursorIndexOfWebcast = CursorUtil.getColumnIndexOrThrow(_cursor, "webcast");
          final int _cursorIndexOfArticle = CursorUtil.getColumnIndexOrThrow(_cursor, "article");
          final int _cursorIndexOfWikipedia = CursorUtil.getColumnIndexOrThrow(_cursor, "wikipedia");
          final List<SpaceLaunch> _result = new ArrayList<SpaceLaunch>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SpaceLaunch _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDateUtc;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDateUtc)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDateUtc);
            }
            _tmpDateUtc = __converters.fromTimestamp(_tmp);
            final String _tmpRocketId;
            if (_cursor.isNull(_cursorIndexOfRocketId)) {
              _tmpRocketId = null;
            } else {
              _tmpRocketId = _cursor.getString(_cursorIndexOfRocketId);
            }
            final Boolean _tmpSuccess;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSuccess)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfSuccess);
            }
            _tmpSuccess = _tmp_1 == null ? null : _tmp_1 != 0;
            final String _tmpDetails;
            if (_cursor.isNull(_cursorIndexOfDetails)) {
              _tmpDetails = null;
            } else {
              _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
            }
            final Links _tmpLinks;
            if (!(_cursor.isNull(_cursorIndexOfWebcast) && _cursor.isNull(_cursorIndexOfArticle) && _cursor.isNull(_cursorIndexOfWikipedia))) {
              final String _tmpWebcast;
              if (_cursor.isNull(_cursorIndexOfWebcast)) {
                _tmpWebcast = null;
              } else {
                _tmpWebcast = _cursor.getString(_cursorIndexOfWebcast);
              }
              final String _tmpArticle;
              if (_cursor.isNull(_cursorIndexOfArticle)) {
                _tmpArticle = null;
              } else {
                _tmpArticle = _cursor.getString(_cursorIndexOfArticle);
              }
              final String _tmpWikipedia;
              if (_cursor.isNull(_cursorIndexOfWikipedia)) {
                _tmpWikipedia = null;
              } else {
                _tmpWikipedia = _cursor.getString(_cursorIndexOfWikipedia);
              }
              _tmpLinks = new Links(_tmpWebcast,_tmpArticle,_tmpWikipedia);
            } else {
              _tmpLinks = null;
            }
            _item = new SpaceLaunch(_tmpId,_tmpName,_tmpDateUtc,_tmpRocketId,_tmpSuccess,_tmpDetails,_tmpLinks);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getLaunchById(final String launchId,
      final Continuation<? super SpaceLaunch> $completion) {
    final String _sql = "SELECT * FROM launches WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (launchId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, launchId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SpaceLaunch>() {
      @Override
      @Nullable
      public SpaceLaunch call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDateUtc = CursorUtil.getColumnIndexOrThrow(_cursor, "dateUtc");
          final int _cursorIndexOfRocketId = CursorUtil.getColumnIndexOrThrow(_cursor, "rocketId");
          final int _cursorIndexOfSuccess = CursorUtil.getColumnIndexOrThrow(_cursor, "success");
          final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
          final int _cursorIndexOfWebcast = CursorUtil.getColumnIndexOrThrow(_cursor, "webcast");
          final int _cursorIndexOfArticle = CursorUtil.getColumnIndexOrThrow(_cursor, "article");
          final int _cursorIndexOfWikipedia = CursorUtil.getColumnIndexOrThrow(_cursor, "wikipedia");
          final SpaceLaunch _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDateUtc;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDateUtc)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDateUtc);
            }
            _tmpDateUtc = __converters.fromTimestamp(_tmp);
            final String _tmpRocketId;
            if (_cursor.isNull(_cursorIndexOfRocketId)) {
              _tmpRocketId = null;
            } else {
              _tmpRocketId = _cursor.getString(_cursorIndexOfRocketId);
            }
            final Boolean _tmpSuccess;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSuccess)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfSuccess);
            }
            _tmpSuccess = _tmp_1 == null ? null : _tmp_1 != 0;
            final String _tmpDetails;
            if (_cursor.isNull(_cursorIndexOfDetails)) {
              _tmpDetails = null;
            } else {
              _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
            }
            final Links _tmpLinks;
            if (!(_cursor.isNull(_cursorIndexOfWebcast) && _cursor.isNull(_cursorIndexOfArticle) && _cursor.isNull(_cursorIndexOfWikipedia))) {
              final String _tmpWebcast;
              if (_cursor.isNull(_cursorIndexOfWebcast)) {
                _tmpWebcast = null;
              } else {
                _tmpWebcast = _cursor.getString(_cursorIndexOfWebcast);
              }
              final String _tmpArticle;
              if (_cursor.isNull(_cursorIndexOfArticle)) {
                _tmpArticle = null;
              } else {
                _tmpArticle = _cursor.getString(_cursorIndexOfArticle);
              }
              final String _tmpWikipedia;
              if (_cursor.isNull(_cursorIndexOfWikipedia)) {
                _tmpWikipedia = null;
              } else {
                _tmpWikipedia = _cursor.getString(_cursorIndexOfWikipedia);
              }
              _tmpLinks = new Links(_tmpWebcast,_tmpArticle,_tmpWikipedia);
            } else {
              _tmpLinks = null;
            }
            _result = new SpaceLaunch(_tmpId,_tmpName,_tmpDateUtc,_tmpRocketId,_tmpSuccess,_tmpDetails,_tmpLinks);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
