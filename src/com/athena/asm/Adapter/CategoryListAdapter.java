package com.athena.asm.Adapter;

import java.util.List;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.athena.asm.R;
import com.athena.asm.aSMApplication;
import com.athena.asm.data.Board;

public class CategoryListAdapter extends BaseAdapter {

	private LayoutInflater m_inflater;
	private List<Board> m_boards;

	public CategoryListAdapter(LayoutInflater inflater, List<Board> boardList) {
		this.m_inflater = inflater;
		this.m_boards = boardList;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View layout = null;
		if (convertView != null) {
			layout = convertView;
		} else {
			layout = m_inflater.inflate(R.layout.category_list_item, null);
		}
		Board board = m_boards.get(position);

		TextView categoryNameTextView = (TextView) layout
				.findViewById(R.id.CategoryName);
		categoryNameTextView.setText(board.getCategoryName());
		TextView moderatorIDTextView = (TextView) layout
				.findViewById(R.id.ModeratorID);
		moderatorIDTextView.setText(board.getModerator());
		TextView boardNameTextView = (TextView) layout
				.findViewById(R.id.BoardName);
		boardNameTextView.setText("[" + board.getEngName() + "]"
				+ board.getChsName());
		layout.setTag(board);
		
		boardNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, aSMApplication.getCurrentApplication().getGuidanceSecondFontSize());

		if (aSMApplication.getCurrentApplication().isNightTheme()) {
			categoryNameTextView.setTextColor(layout.getResources().getColor(
					R.color.status_text_night));
			moderatorIDTextView.setTextColor(layout.getResources().getColor(
					R.color.status_text_night));
			boardNameTextView.setTextColor(layout.getResources().getColor(
					R.color.status_text_night));
		}

		return layout;
	}

	@Override
	public int getCount() {
		return m_boards.size();
	}

	@Override
	public Object getItem(int position) {
		return m_boards.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}
