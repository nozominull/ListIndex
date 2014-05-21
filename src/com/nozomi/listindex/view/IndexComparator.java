package com.nozomi.listindex.view;

import java.util.Comparator;

public class IndexComparator implements Comparator<IndexString> {

	@Override
	public int compare(IndexString lhs, IndexString rhs) {
		boolean isLhsLetter = lhs.getFirstChar() >= 'A'
				&& lhs.getFirstChar() <= 'Z';
		boolean isRhsLetter = rhs.getFirstChar() >= 'A'
				&& rhs.getFirstChar() <= 'Z';

		if (isLhsLetter && !isRhsLetter) {
			return 1;
		} else if (!isLhsLetter && isRhsLetter) {
			return -1;
		} else {
			if (lhs.getFirstChar() == rhs.getFirstChar()) {
				// chs
				// return
				// Collator.getInstance(Locale.CHINA).compare(lhs.getString(),
				// rhs.getString());
				return lhs.getString().compareTo(rhs.getString());
			} else {
				return lhs.getFirstChar() - rhs.getFirstChar();
			}

		}
	}
}
