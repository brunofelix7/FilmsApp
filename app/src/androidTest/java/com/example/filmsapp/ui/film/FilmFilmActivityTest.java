package com.example.filmsapp.ui.film;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.example.filmsapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class FilmFilmActivityTest {

    @Rule
    public ActivityTestRule<FilmActivity_> mActivityTestRule = new ActivityTestRule<>(FilmActivity_.class);

    private FilmActivity_ mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View toolbar = mActivity.findViewById(R.id.toolbar);
        View rv_films = mActivity.findViewById(R.id.rv_films);
        assertNotNull(toolbar);
        assertNotNull(rv_films);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}