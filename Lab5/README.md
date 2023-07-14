| Outline | Value |
| ------- | ----- |
| Course | SEG 3503 |
| Professor | Mohammed Ibrahim |
| TA | Joesph Abonasara |
| Team | Brice Joan Ngnawo Soh - nsoh087@uottawa.ca - 300262882, Greg Nathan Ngongang Ouandji - gngon065@uottawa.ca, Aaron Muganda - amuga022@uottawa.ca - 300246117 |

<b>1. Grades</b>
--------------------
<b>Stubbed Code:</b>
<img src = images/stubbed_code.png/>
In this part, we created stubs with the purpose of creating the signature for the methods that are connected to the rest of the syste. These methods are only there to see if our modules connect together properly to form our system. For this, we must ensure that our parameters are the same as the ones we will use in our final implementation. We randomly returned values so as to make sure the backend components are properly interconnected

<b>Output on the web with Stubbed Code:</b>
<img src = images/grades_stub_code.png/>
With the stubbed code, we can see that the web app is able to display our randomly generated grades as expected. This means that the back end of our web app is properly connected to the front end. The observation with make is that the percentage grade "39%" does not correspond with the Numeric Grade "5" and Letter Grade "A+". We will have to implement a code that works properly to give us the desired output.

<b>Output After Refactoring the Stubbed Code</b>
<img src = images/grade_modified_stub_code.png/>
<img src = images/grade_modified_stub.png/>
After refactoring the stub code, we can observe that the percentage grade corresponds with the numeric grade and letter grade in both cases.

<b>Refactored Stub Code</b>
<img src = />

----------------------------------

<b>2. Twitter</b>
-----------------------------------
<b>Test Cases:</b>
 


    

    @Test
    void isMentionned_lookForAtSymbol() {
        Twitter twitter = partialMockBuilder(Twitter.class)
                .addMockedMethod("loadTweet")
                .createMock();

        expect(twitter.loadTweet()).andReturn("hello @me").times(2);
        replay(twitter);

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(true, actual);

        actual = twitter.isMentionned("you");
        assertEquals(false, actual);
    }

    @Test
    void isMentionned_dontReturnSubstringMatches() {
        Twitter twitter = partialMockBuilder(Twitter.class)
                .addMockedMethod("loadTweet")
                .createMock();

        expect(twitter.loadTweet()).andReturn("hello @meat").times(2);
        replay(twitter);

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(false, actual);

        actual = twitter.isMentionned("meat");
        assertEquals(true, actual);
    }

    @Test
    void isMentionned_superStringNotFound() {
        Twitter twitter = partialMockBuilder(Twitter.class)
                .addMockedMethod("loadTweet")
                .createMock();

        expect(twitter.loadTweet()).andReturn("hello @me").times(2);
        replay(twitter);

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(true, actual);

        actual = twitter.isMentionned("meat");
        assertEquals(false, actual);
    }

    @Test
    void isMentionned_handleNull() {
        Twitter twitter = partialMockBuilder(Twitter.class)
                .addMockedMethod("loadTweet")
                .createMock();

        expect(twitter.loadTweet()).andReturn(null).times(2);
        replay(twitter);

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(false, actual);

        actual = twitter.isMentionned("meat");
        assertEquals(false, actual);
    }

    @Test
    void isMentionned_handleNull() {
        Twitter twitter = partialMockBuilder(Twitter.class)
                .addMockedMethod("loadTweet")
                .createMock();

        expect(twitter.loadTweet()).andReturn(null).times(2);
        replay(twitter);

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(false, actual);

        actual = twitter.isMentionned("meat");
        assertEquals(false, actual);
    }

