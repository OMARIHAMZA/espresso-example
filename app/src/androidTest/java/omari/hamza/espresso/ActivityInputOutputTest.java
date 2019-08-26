package omari.hamza.espresso;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("omari.hamza.espresso", appContext.getPackageName());
    }

    @Test
    public void activityTwoLaunch(){
        onView(withId(R.id.nextButton)).perform(click());
        onView(withId(R.id.messageTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void testInputOutput(){
        String message = "This is the input.";
        onView(withId(R.id.messageEditText)).perform(typeText(message));
        onView(withId(R.id.nextButton)).perform(click());
        onView(withId(R.id.messageTextView)).check(matches(withText(message)));
    }

    @Test
    public void iterateSpinnerItems(){
        String[] mArray = ((MainActivity) mActivityRule.getActivity()).getEntries();
        for (String s : mArray) {
            onView(withId(R.id.spinner)).perform(click());
            onData(is(s)).perform(click());
            onView(withId(R.id.phoneTextView)).check(matches(withText(containsString(s))));
        }
    }

}
