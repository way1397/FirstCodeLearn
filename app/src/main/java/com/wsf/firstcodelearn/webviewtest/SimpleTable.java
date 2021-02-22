package com.wsf.firstcodelearn.webviewtest;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.wsf.firstcodelearn.R;

import java.util.List;

public class SimpleTable extends TableLayout {
    private List<List<String>> rowList;

    public SimpleTable(Context context) {
        this(context, null);
    }

    public SimpleTable(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTable();
    }

    private void initTable() {
        setOrientation(VERTICAL);
        setShowDividers(SHOW_DIVIDER_BEGINNING | SHOW_DIVIDER_MIDDLE | SHOW_DIVIDER_END);
        setDividerDrawable(getContext().getDrawable(R.drawable.table_divider_v));
    }

    public void setRowList(List<List<String>> lists) {
        if (lists == null || lists.size() <= 1) {
            return;
        }
        for (int i = 0; i < lists.size(); i++) {
            List<String> itemList = lists.get(i);
            TableRow tableRow = new TableRow(getContext());
            tableRow.setOrientation(HORIZONTAL);
            tableRow.setShowDividers(SHOW_DIVIDER_BEGINNING | SHOW_DIVIDER_MIDDLE | SHOW_DIVIDER_END);
            tableRow.setDividerDrawable(getContext().getDrawable(R.drawable.table_divider_h));
            if (itemList == null || itemList.size() <= 0) {
                break;
            }
            for (int j = 0; j < itemList.size(); j++) {
                String itemStr = itemList.get(j);
                TextView tvItem = new TextView(getContext());
                tvItem.setGravity(Gravity.CENTER);
                tvItem.setTextColor(Color.parseColor("#1E1E1E"));
                tvItem.setTextSize(dp2px(getContext(), 4));
                tvItem.setPadding(dp2px(getContext(), 7), dp2px(getContext(), 5),
                        dp2px(getContext(), 7), dp2px(getContext(), 5));
                tvItem.setText(itemStr);
                tableRow.addView(tvItem);
            }
            addView(tableRow);
        }
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
