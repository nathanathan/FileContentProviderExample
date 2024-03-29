package org.opendatakit.FileContentProviderExample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import org.json.*;

public class FileContentProviderExample extends ContentProvider {
	
	private void writeJSONObjectToFile(JSONArray ja, String outPath) throws JSONException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(outPath));
		out.write(ja.toString(4));
		out.close();
	}
	@Override
	public ParcelFileDescriptor openFile(Uri uri, String mode) 
			throws FileNotFoundException {
		Log.i("FileContentProviderExample", "openFile");
		File tempFile;
		try {
			JSONArray ja = new JSONArray();
			JSONObject a = new JSONObject();
			a.put("name", "item_a");
			a.put("label", "Item A");
			ja.put(a);
			JSONObject b = new JSONObject();
			b.put("name", "item_b");
			b.put("label", "Item B");
			ja.put(b);
			Log.i("FileContentProviderExample", "created json.");
			tempFile = File.createTempFile("response", "json", this.getContext().getCacheDir());
			writeJSONObjectToFile(ja, tempFile.getPath());
			Log.i("FileContentProviderExample", "saved json");
		} catch (Exception e) {
			throw new FileNotFoundException(e.toString());
		}
		Log.i("FileContentProviderExample", "returning...");
		return ParcelFileDescriptor.open(tempFile, ParcelFileDescriptor.MODE_READ_ONLY);
	}
	
	//Stubs below here:
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
}
