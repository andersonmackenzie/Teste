package br.com.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDados extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "dados.db";
	public static final int VERSAO = 1;

	public static final String TABLE_NAME = "DADOS_USER";
	public static final String ID = "_id";
	public static final String VALOR = "DADO";

	public UserDados(Context context) {

		super(context, DATABASE_NAME, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + VALOR
				+ " TEXT NOT NULL;");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

}
