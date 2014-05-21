package com.nozomi.listindex.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.nozomi.listindex.R;
import com.nozomi.listindex.view.IndexComparator;
import com.nozomi.listindex.view.IndexView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Random random = new Random();
	private ArrayList<Item> itemArray = new ArrayList<Item>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		initView();
	}

	private void initView() {

		final ListView itemListView = (ListView) findViewById(R.id.item_list);
		for (int i = 0; i < 300; i++) {
			itemArray.add(new Item(generateRandomWord(), R.drawable.nozomi));
		}

		Collections.sort(itemArray, new IndexComparator());
		ItemAdapter itemAdapter = new ItemAdapter(this);
		itemListView.setAdapter(itemAdapter);
		TextView selectIndexView = (TextView) findViewById(R.id.select_index);

		IndexView indexView = (IndexView) findViewById(R.id.index);
		indexView.init(itemListView, selectIndexView);

	}

	private class ItemAdapter extends BaseAdapter {

		private Context context;

		public ItemAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			return itemArray.size();
		}

		@Override
		public Object getItem(int position) {
			return itemArray.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(context).inflate(
						R.layout.item, null, false);

				holder.picView = (ImageView) convertView.findViewById(R.id.pic);
				holder.nameView = (TextView) convertView
						.findViewById(R.id.name);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Item item = itemArray.get(position);
			String name = item.getName();
			holder.picView.setImageResource(item.getPic());
			holder.nameView.setText(name);

			return convertView;
		}

		private class ViewHolder {
			ImageView picView;
			TextView nameView;
		}
	}

	private String generateRandomWord() {

		int length = 1 + random.nextInt(5);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append((char) (32 + random.nextInt(127 - 32)));
		}
		return sb.toString();
	}
}
