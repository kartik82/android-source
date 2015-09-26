package com.bloc.objects;

class PopSong extends Song {
	// The number of weeks this song stayed on Billboard's top 100
	int mWeeksOnBillboard;

	/*
	 * PopSong
	 *
	 * Side-effects: Assigns some default ensemble, title,
	 *				 year and number of weeks on billboard
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the first PopSong constructor
	/************************************************/

	PopSong() {
		this(new Ensemble("Lifehouse"), "You and Me", 2006, 62);
	}

	/*
	 * PopSong
	 * 
	 * Side-effects: Sets the year of release to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the second PopSong constructor
	/************************************************/

	PopSong(Ensemble ensemble, String title) {
		this.mEnsemble = ensemble;
		this.mTitle = title;
	}

	/*
	 * PopSong
	 *
	 * Side-effects: Sets the weeks on billboard to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the third PopSong constructor
	/************************************************/

	PopSong(Ensemble ensemble, String title, int yearReleased) {
		this.mEnsemble = ensemble;
		this.mTitle = title;
		this.mYearReleased = yearReleased;	
	}

	/*
	 * PopSong
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 * @param weeksOnBillboard number of weeks this song lasted on the
	 *		  				   Billboard's top 100 (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the fourth PopSong constructor
	/************************************************/

	PopSong(Ensemble ensemble, String title, int yearReleased, int weeksOnBillboard) {
		this.mEnsemble = ensemble;
		this.mTitle = title;
		this.mYearReleased = yearReleased;
		this.mWeeksOnBillboard = weeksOnBillboard;		
	}

}