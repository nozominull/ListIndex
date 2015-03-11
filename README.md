ListIndex
=========

display an index for listview


Screen Shot
----------------
![image](https://raw.github.com/xuyangbill/ListIndex/master/screenshots/1.png)
![image](https://raw.github.com/xuyangbill/ListIndex/master/screenshots/2.png)

How to use
-------------

*To run Sample App.*

  1. clone project.

  2. run on your android phone.

*To use AutoHideScrollView.*

  1. clone project.

  2. copy all files in com.nozomi.listindex.view

*Simple Example.*

```xml
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <ListView
        android:id="@+id/item_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_toLeftOf="@+id/index"
        android:scrollbars="none" />

    <com.nozomi.listindex.view.IndexView
        android:id="@+id/index"
        android:layout_width="20dp"
        android:layout_height="match_parent"
        android:background="@android:color/black"
        android:layout_alignParentRight="true"/>

    <TextView
        android:id="@+id/select_index"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:textSize="60sp"
        android:visibility="gone" />

</RelativeLayout>
```

```java

		//Item implements IndexString
		ArrayList<Item> itemArray = new ArrayList<Item>();
		//init data here
		Collections.sort(itemArray, new IndexComparator());
		//ItemAdapter.getItem should return IndexString
		ItemAdapter itemAdapter = new ItemAdapter(this);		
		itemListView.setAdapter(itemAdapter);
		//display center text
		TextView selectIndexView = (TextView) findViewById(R.id.select_index);

		IndexView indexView = (IndexView) findViewById(R.id.index);
		indexView.init(itemListView, selectIndexView);
```
plz check code for more details.
