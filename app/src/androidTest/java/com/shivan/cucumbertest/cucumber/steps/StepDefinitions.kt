package com.shivan.cucumbertest.cucumber.steps

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.shivan.cucumbertest.MainActivity
import com.shivan.cucumbertest.R
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * This defines all the translations from Gherkin (semi-English) sentences to Java
 */
@SuppressWarnings("JUnitTestCaseWithNoTests")
@RunWith(AndroidJUnit4::class)
class StepDefinitions {
    private var mInstrumentationContext: Context? = null
    private var mAppContext: Context? = null
//    private var mCurrentPage: BasePage? = null
    private var mActivity: Activity? = null
//    private var mFullWakeUpLock: PowerManager.WakeLock? = null
//    private var mCountingIdlingResourceListener: CountingIdlingResourceListenerImpl? = null

    @Rule
    private val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java,
            false, false)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mInstrumentationContext = InstrumentationRegistry.getContext()
        mAppContext = InstrumentationRegistry.getTargetContext()
//        registerIdlingResources()
        mActivity = mActivityRule.launchActivity(Intent()) // Start Activity before each test scenario
//        turnOnScreenOfTestDevice()
    }

//    private fun registerIdlingResources() {
//        mCountingIdlingResourceListener = CountingIdlingResourceListenerImpl("ButtonAnimationStarter")
//        LoginActivity.setIdlingNotificationListener(mCountingIdlingResourceListener)
//        Espresso.registerIdlingResources(mCountingIdlingResourceListener!!.getCountingIdlingResource())
//    }

//    private fun turnOnScreenOfTestDevice() {
//        val powerManager = mActivity!!.getSystemService(Context.POWER_SERVICE) as PowerManager
//
//        mFullWakeUpLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP, "FULL WAKE UP LOCK")
//        // This will turn on the screen during the test (lock screen still needs to be always disabled)
//        mFullWakeUpLock!!.acquire()
//    }

    /**
     * All the clean up of application's data and state after each scenario must happen here
     * The last call of this method should always be the call to parent's tear down method
     */
    @After
    @Throws(Exception::class)
    fun tearDown() {
        mActivity?.finish()
//        LoginActivity.setIdlingNotificationListener(null)
//        Espresso.unregisterIdlingResources(mCountingIdlingResourceListener!!.getCountingIdlingResource())
//        ActivityFinisher.finishOpenActivities() // Required for testing App with multiple activities
//        letScreenOfTestDeviceTurnOff()
    }

//    private fun letScreenOfTestDeviceTurnOff() {
//        if (mFullWakeUpLock != null) {
//            mFullWakeUpLock!!.release()
//        }
//    }

    /**
     * Wait for the debugger to be manually attached to this running process.
     * Use this to debug test execution by adding this step to your test scenario and
     * when the test is running in Android Studio choose menu "Run - Attach debugger to Android process",
     * finally select the name of your app package from the list of processes displayed.
     */
//    @Given("^I wait for manual attachment of the debugger$")
//    @Throws(InterruptedException::class)
//    fun wait_for_manual_attachment_of_debugger() {
//        while (!Debug.isDebuggerConnected()) {
//            Thread.sleep(1000)
//        }
//    }

    @Given("^Видим главный экран$")
    fun focus_on_the_main_screen() {
        assertNotNull(mActivity)
//        mCurrentPage = LoginPage()
    }

    @When("^в поле ввода набираем \"(.+)\"$")
    fun enter_the_data(data: String) {
        onView(withId(R.id.input)).perform(typeText(data), closeSoftKeyboard())
//        mCurrentPage = mCurrentPage!!.`is`(LoginPage::class.java).doLogin(userName, password)
    }

    @When("^поле ввода оставляем пустым$")
    fun clear_the_data() {
        onView(withId(R.id.input)).perform(clearText(), closeSoftKeyboard())
//        mCurrentPage = mCurrentPage!!.`is`(LoginPage::class.java).doLogin(userName, password)
    }

    @And("^жмем на кнопку \"(.+)\"$")
    fun tap_on_button(buttonAliasOrText: String) {
        when (buttonAliasOrText) {
            "FAB" -> onView(withId(R.id.fab)).perform(click())
            else -> onView(withText(buttonAliasOrText)).perform(click())
        }
//        mCurrentPage = mCurrentPage!!.`is`(LoginPage::class.java).doLogin(userName, password)
    }

    @Then("^появляется сообщение \"(.+)\"$")
    fun i_see_the_message(message: String) {
        onView(withText(message)).check(matches(isDisplayed()))
//        "Replace with your own action"
//        mCurrentPage!!.`is`(WelcomePage::class.java)
    }

//    @And("^the title is \"(.+)\"$")
//    fun the_title_is(title: String) {
//        mCurrentPage!!.`is`(WelcomePage::class.java).checkTitle(title)
//    }

    companion object {

        val TAG = StepDefinitions::class.java.simpleName
    }
}
