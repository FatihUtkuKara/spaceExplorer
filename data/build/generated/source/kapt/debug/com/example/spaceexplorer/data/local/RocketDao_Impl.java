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
import com.example.spaceexplorer.data.model.Rocket;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RocketDao_Impl implements RocketDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Rocket> __insertionAdapterOfRocket;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllRockets;

  public RocketDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRocket = new EntityInsertionAdapter<Rocket>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `rockets` (`id`,`name`,`description`,`active`,`company`,`costPerLaunch`,`successRatePct`,`firstFlight`,`country`,`wikipedia`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Rocket entity) {
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
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        final int _tmp = entity.getActive() ? 1 : 0;
        statement.bindLong(4, _tmp);
        if (entity.getCompany() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCompany());
        }
        statement.bindLong(6, entity.getCostPerLaunch());
        statement.bindLong(7, entity.getSuccessRatePct());
        if (entity.getFirstFlight() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getFirstFlight());
        }
        if (entity.getCountry() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getCountry());
        }
        if (entity.getWikipedia() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getWikipedia());
        }
      }
    };
    this.__preparedStmtOfDeleteAllRockets = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM rockets";
        return _query;
      }
    };
  }

  @Override
  public Object insertRocket(final Rocket rocket, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRocket.insert(rocket);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllRockets(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllRockets.acquire();
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
          __preparedStmtOfDeleteAllRockets.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getRocketById(final String rocketId,
      final Continuation<? super Rocket> $completion) {
    final String _sql = "SELECT * FROM rockets WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (rocketId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, rocketId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Rocket>() {
      @Override
      @Nullable
      public Rocket call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfCompany = CursorUtil.getColumnIndexOrThrow(_cursor, "company");
          final int _cursorIndexOfCostPerLaunch = CursorUtil.getColumnIndexOrThrow(_cursor, "costPerLaunch");
          final int _cursorIndexOfSuccessRatePct = CursorUtil.getColumnIndexOrThrow(_cursor, "successRatePct");
          final int _cursorIndexOfFirstFlight = CursorUtil.getColumnIndexOrThrow(_cursor, "firstFlight");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfWikipedia = CursorUtil.getColumnIndexOrThrow(_cursor, "wikipedia");
          final Rocket _result;
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
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfActive);
            _tmpActive = _tmp != 0;
            final String _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getString(_cursorIndexOfCompany);
            }
            final long _tmpCostPerLaunch;
            _tmpCostPerLaunch = _cursor.getLong(_cursorIndexOfCostPerLaunch);
            final int _tmpSuccessRatePct;
            _tmpSuccessRatePct = _cursor.getInt(_cursorIndexOfSuccessRatePct);
            final String _tmpFirstFlight;
            if (_cursor.isNull(_cursorIndexOfFirstFlight)) {
              _tmpFirstFlight = null;
            } else {
              _tmpFirstFlight = _cursor.getString(_cursorIndexOfFirstFlight);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpWikipedia;
            if (_cursor.isNull(_cursorIndexOfWikipedia)) {
              _tmpWikipedia = null;
            } else {
              _tmpWikipedia = _cursor.getString(_cursorIndexOfWikipedia);
            }
            _result = new Rocket(_tmpId,_tmpName,_tmpDescription,_tmpActive,_tmpCompany,_tmpCostPerLaunch,_tmpSuccessRatePct,_tmpFirstFlight,_tmpCountry,_tmpWikipedia);
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
