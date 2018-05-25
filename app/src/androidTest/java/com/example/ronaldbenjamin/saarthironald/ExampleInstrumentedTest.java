package com.example.ronaldbenjamin.saarthironald;

import android.content.Context;
import android.os.Parcel;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testParcel() {
        final AspectRatio original = AspectRatio.of(4, 3);
        final Parcel parcel = Parcel.obtain();
        try {
            parcel.writeParcelable(original, 0);
            parcel.setDataPosition(0);
            final AspectRatio restored = parcel.readParcelable(getClass().getClassLoader());
            assertNotNull(restored);
            assertThat(restored.getX(), is(4));
            assertThat(restored.getY(), is(3));
            // As the first instance is alive, the parceled result should still be the same instance
            assertThat(restored, is(sameInstance(original)));
        } finally {
            parcel.recycle();
        }
    }
}
