package com.mobilewe.wemobile.resources.strings.en

import com.mobilewe.wemobile.resources.strings.IStringResources

data class English(
    override val weSacco: String = "WesaccoMobile",
    override val backgroundDescription: String = "background image",
    override val loginWelcomeMessage: String = "Welcome To Beep Beep App",
    override val loginSubWelcomeMessage: String = "Login to access all the features",
    override val usernameLabel: String = "Username",
    override val passwordLabel: String = "Password",
    override val login: String = "Login",
    override val keepMeLoggedIn: String = "Keep me logged in",
    override val signUpNow: String = "Sign up now",
    override val signUpDescription: String = "Don't have an account ?",
    override val home: String = "Home",
    override val search: String = "Search",
    override val orders: String = "Orders",
    override val notification: String = "Notification",
    override val profile: String = "Profile",
    override val wallet: String = "Wallet",
    override val welcome: String = "Welcome",
    override val searchHint: String = "Search for meal, restaurant",
    override val invalidUsername: String = "invalid username",
    override val languageAskAboutLanguage: String = "What language do you speak?",
    override val selectLanguage: String = "Pick your language.",
    override val joinBpToday: String = "Join Beep Beep Today!",
    override val createYourAccount: String = "Create your account",
    override val next: String = "Next",
    override val justOnMoreStep: String = "Just one more step!",
    override val completeYourRegistration: String = "Complete your registration",
    override val fullName: String = "Full name",
    override val email: String = "Email",
    override val mobileNumber: String = "Mobile number",
    override val signUp: String = "Sign up",
    override val username: String = "Username",
    override val password: String = "Password",
    override val ridePreferredTitle: String = "Which do you prefer for your taxi rides?",
    override val ridePreferredSubTitle: String = "Help us improve your experience with us.",
    override val today: String = "Today",
    override val thisWeek: String = "This Week",
    override val invalidPassword: String = "Invalid Password",
    override val unknownError: String = "Unknown Error",
    override val wifiDisabled: String = "WIFI Disabled",
    override val requestFailed: String = "Request Failed",
    override val noInternet: String = "No Internet",
    override val invalidPhoneNumber: String = "Invalid Phone Number",
    override val invalidEmail: String = "Invalid Email",
    override val invalidFullName: String = "Invalid Full Name",
    override val oppsRegistrationNotCompleted: String = "Opps, Registration Not Completed",
    override val address: String = "Address",
    override val invalidAddress: String = "Invalid Address",
    override val yourAddress: String = "Your Address",
    override val mostOrdered: String = "Most Ordered",
    override val sweets: String = "Sweets",
    override val free: String = "Free",
    override val loginToAddToFavourite: String = "Please login to add",
    override val addToCart: String = "Add to cart",
    override val mealAddedToYourCart: String = "Meal added to your cart",
    override val mealFailedToAddInCart: String = "error while add Meal to your cart",
    override val pleaseLogin: String = "Please log in to access your profile",
    override val message: String = "Message",
    override val supportTeam: String = "Support team",
    override val sendMessageToStartLiveChat: String = "Send a message to start the live chat!",
    override val confirmPasswordLabel: String = "Confirm Password",
    override val greetings: String = "Hey,",
    override val paySomeone: String = "Pay someone",
    override val paySomeoneDesc: String = "To Wallet bank,or mobile number",
    override val requestMoney: String = "Request money",
    override val requestMoneyDesc: String = "Request money from WeSaccoMobile users",
    override val buyAirtime: String = "Buy airtime",
    override val buyAirtimeDesc: String = "Top-up or send airtime across all network",
    override val payBillAndBuyGoods: String = "Pay bill & buy goods",
    override val payBillDescr: String = "Manage all your bills and merchant transactions",
    override val payBillTitle: String = "Pay Bill",
    override val buyGoodsTitle: String = "Buy Goods",
    override val passwordVisibleContentDescription: String = "Hide password",
    override val passwordHiddenContentDescription: String = "Show password",
    override val payBillNumber: String = "PayBill Number",
    override val accountNumber: String = "Account Number",
    override val payBillAmount: String = "Amount",
    override val pinHint: String = "Create Pin",
    override val confirmPin: String = "Confirm Pin",
    override val currentPin: String = "Current Pin",
    override val newPin: String = "New Pin",
    override val confirmNewPin: String = "Confirm New Pin",
    override val currentPassword: String = "Current Password",
    override val confirmNewPassword: String = "Confirm New Password",
    override val newPassword: String = "New Password",
    override val transaction: String = "Transaction",
    override val submit: String = "Submit",
    override val userProfile: String = "UserProfile",
    override val amount: String = "Amount",
    override val minAmount: String = "minimum amount 5",
    override val payWithSacco: String = "Pay with RideSacco",
    override val helpCenter: String = "HELP",
    override val appTheme: String = "App",
    override val turnOnIncognito: String = "App",
    override val appLanguage: String = "Language",
    override val settings: String = "Setting",
    override val driveMode: String = "Drive Mode",
    override val childMode: String = "Chidl Note",
    override val timeWatched: String = "Time Watch",
    override val accountData: String = "Account Data",
    override val rateUsOnPlayStore: String = "Rate",
    override val feedback: String = "Feedbacck",
    override val forum: String = "Forum",
    override val privacyPolicy: String = "Policy Privacy",
    override val termsOfService: String = "Terms",
    override val nightLight: String = "Night",
    override val phoneNumber: String = "Phone Number",
    override val buyAirtimeHomeTitle: String = "Buy airtime",
    override val tillNumber: String = "Till Number",
    override val businessNumber: String = "Business Number",
    override val deposit: String = "Deposit",
    override val withdraw: String = "Withdraw",
    override val paybill: String = "Pay Bills",
    override val buygoods: String = "Buy Goods",
    override val buyGoods: String = "Buy Goods",
    override val sendMoneyUnderscore: String = "Send Money",
    override val savings: String = "Savings",
    override val ourMarket: String = "Market",
    override val loan: String = "Loan",
    override val billPayAndTillPayHint: String = "Bill & Till Pay",
    override val busTravelHint: String = "Bus",
    override val flightHint: String = "Flight",
    override val trainHint: String = "Train",
    override val hotelHint: String = "Hotel",
    override val schedulePayment: String = "Schedule payment",
    override val addFavourite: String = "Add a favorite",
    override val favorite: String = "Favorite",
    override val ownEquityAccount: String = "Own Equity account",
    override val anotherEquityAccount: String = "Another Equity account",
    override val payTopUp: String = "Pay to card",
    override val creditPrepaid: String = "Credit and prepaid cards",
    override val mobileWallet: String = "Mobile money",
    override val sendToMobile: String = "Send to mobile money providers",
    override val anotherBank: String = "Another Bank",
    override val payBill: String = "Pay bill",
    override val withdrawHint: String = "Withdraw",
    override val promptInfoTitle: String = "Sample App Authentication",
    override val promptInfoSubtitle: String = "Please login to get access",
    override val promptInfoDescription: String = "Sample App is using Android biometric authentication",
    override val promptInfoUseAppPassword: String = "Use app password",
    override val continuee: String = "Continue",
    override val saccoApp: String = "Authenticate with your fingerprint",
    override val loanStatement: String = "Statement",
    override val requestLoan: String = "Request Loan",
    override val payLoan: String = "Pay Loan",
    override val recentTransaction: String = "Recent Transaction",
    override val dontHaveAnAccount: String = "Don't have an account?",
    override val alreadyHaveAnAccount: String = "Already have an account?",
    override val yourBalance: String = "Your Balance",
    override val checkAllTransaction: String = "See all transactions",
    override val managePin: String = "Manage Pin",
    override val checkSaccoStatement: String = "Sacco Statement",
    override val electronics: String = "Electronics",
    override val loanBalance: String = "Balance:",
    override val limit: String = "Limit",
    override val dueDate: String = "Due Date",
    override val signIn: String = "Sign In",
    override val emailOrMobileNumber: String = "Email or Mobile Number",
    override val emailHint: String = "Email",
    override val userRegisterNamesHint: String = "Enter your full Name",
    override val mobileNumberHint: String = "Enter your Mobile Number",
    override val idNumberHint: String = "ID Number",
    override val helloBlankFragment: String = "Hello blank fragment",
    override val enterPin: String = "ENTER PIN TO UNLOCK",
    override val account: String = "Account",
    override val shopHeaderText: String = "We'd like to show some more about our Sacco",
    override val amountSupportText: String = "Minimum amount is Ksh 1",
    override val transactionDetail: String = "Transaction Detail",
    override val recipientNo: String = "Payment Reference",
    override val date: String = "Date/Time",
    override val moneyIn: String = "Money In",
    override val moneyOut: String = "Money Out",
    override val moneyBalance: String = "Balance",
    override val transactionType: String = "Transaction Type",
    override val totalAmount: String = "Total",
    override val availableBalance: String = "Available Balance",
    override val statement: String = "Statement",
    override val onboardingOneTitle: String = "Lend, Save, Spend, Send and Pay Bills with Ease!",
    override val onboardingOneDescription: String = "Our app is designed to help you manage your money with ease, so sign up now and start taking control of your financial future!",
    override val onboardingTwoTitle: String = "Manage Your Money Better with Our Finance App!",
    override val onboardingTwoDescription: String = "Welcome to our finance app! Our powerful yet easy-to-use platform is designed to help you take control of your finances and make informed decisions.",
    override val onboardingThreeTitle: String = "Msaidizi Wako Binafsi wa Kikundi cha Sacco",
    override val onboardingThreeDescription: String = "App yetu ni kama kuwa na msaidizi binafsi wa kikundi cha Sacco, kwenye kifaa chako cha mkononi. Kwa huduma zetu zenye nguvu, utaweza kudhibiti pesa zako kwa urahisi.",
    override val welcomeToSacco: String = "Hello, welcome to Sacco Community.",
    override val welcomeTitleOne: String = "Welcome to WeSacco",
    override val welcomeSubOne: String = "Our Sacco community app is designed to help you connect with fellow members, contribute to your savings and investments, and pay bills with ease.",
    override val welcomeTitleTwo: String = "Woohoo! You're exactly who we've been looking for!",
    override val welcomeTitleThree: String = "We've got you covered!",
    override val welcomeSubTwo: String = "Here's a couple of things to get you excited about RideSacco.",
    override val introFeatureOneTitle: String = "Simplify your financial life with our App!",
    override val introFeatureOneDesc: String = "Our app makes managing your money easy. With intuitive interface and features, you'll be able to keep track of your spending and savings effortlessly.",
    override val introFeatureTwoTitle: String = "Take control of your Sacco finances",
    override val introFeatureTwoDesc: String = "Manage and spend from your sacco and mobile money accounts from Our App.",
    override val introFeatureThreeTitle: String = "Safer by design",
    override val introFeatureThreeDesc: String = "We leveraged Android's built-in security designs to keep your information secure at all times.",
    override val exploreBtnText: String = "Continue without sign in",
    override val continueWithGoogle: String = "Continue with Google",
    override val aboutSaccoRide: String = "Welcome to WeSacco! We're committed to protecting your privacy and providing you with a great user experience. By using MyFinance, you agree to our Privacy Policy, Terms and Conditions, and Service Charter.",
    override val saccoPrivacyPolicy: String = "At WeSacco, we take your privacy seriously. We will never share your personal information with third parties without your consent. We use industry-standard security measures to protect your data and prevent unauthorized access. By using MyFinance, you agree to our Privacy Policy.",
    override val saccoTermsAndConditions: String = "By using WeSacco, you agree to our Terms and Conditions. You must be at least 18 years old to use our services. You are responsible for keeping your account information up to date and secure. MyFinance reserves the right to suspend or terminate your account if you violate our policies or engage in illegal activity. We are not responsible for any losses or damages resulting from your use of our services.",
    override val saccoServiceCharter: String = "At WeSacco, we are committed to providing you with high-quality service. Our goal is to make it easy for you to manage your finances and achieve your goals. If you have any questions or concerns, please contact us at support@myfinance.com.",
    override val seeAll: String = "See all",
    override val bankTransfer: String = "Bank Transfer",
    override val recipientProvider: String = "Recipient Provider",
    override val accountType: String = "Account Type",
    override val allRecipientWithEmoji: String = "🌎 Mpesa",
    override val pin: String = "Enter Pin",
    override val enterYourLoan: String = "Enter your PIN to access your Loans",
    override val apply: String = "Apply",
    override val selectFinishDateTitle: String = "Select End Date",
    override val notFoundEmail: String = "not found",
    override val copyToClipboard: String = "Copied to clipboard",
    override val openAccount: String = "Open account",
    override val goalSaving: String = "Goal Savings",
    override val fixedSaving: String = "Fixed Savings",
    override val targetSavings: String = "Target Savings",
    override val goalSavingsDescription: String = "This is goal saving description",
    override val passwordHint: String = "Enter password",
    override val reEnterPasswordHint: String = "Re-enter your password",
    override val createPassword: String = "Create password",
    override val createPasswordHeader: String = "Create a strong password",
    override val createPasswordHint: String = "The harder the password, the better and safer",
    override val passwordTitle: String = "Password",
    override val validateHeader: String = "What is required?",
    override val validateLetter: String = "Must contain both numbers, uppercase and lowercase letters",
    override val validateCharLong: String = "Must be at least 8 characters long",
    override val validateSpecialChar: String = "Must contain a special character (e.g. !@#$&)",
    override val passwordMatch: String = "Password must match",
    override val pinValidateHeader: String = "How to create a secure PIN:",
    override val validateSequence: String = "Avoid number sequences (e.g. 1234 or 9876)",
    override val validateRepetitive: String = "Avoid using repetitive digits (e.g. 0000, 1111)",
    override val verifyHeader: String = "How would you like to get verified?",
    override val termsAndConditions: String = "Terms and Conditions",
    override val serviceCharter: String = "Service Charter",
    override val logout: String = "Logout",
    override val share: String = "Share",
    override val save: String = "Save",
    override val confirmPassword: String = "Confirm Password"
) : IStringResources
