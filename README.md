# Kotlin Databinding Validator

[![](https://jitpack.io/v/schatzlabs/databinding-validator.svg)](https://jitpack.io/#schatzlabs/databinding-validator)
![Android CI](https://github.com/schatzlabs/databinding-validator/workflows/Android%20CI/badge.svg?branch=develop)

This is a Kotlin databinding library for input validation


## How it works:

### Step 1. Add the JitPack repository to your project's build file

```sh
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

### Step 2. Add the library to you dependencies section in your app's build.gradle file

```sh
dependencies {
    implementation 'com.github.zakayothuku:databinding-validator:1.0.0-alpha01'
}
```

### Make sure you have enabled DataBinding for your project in your app's build.gradle file

```sh
dataBinding { 
   enabled true 
}
```

Then sync your project to download the dependencies.

### Step 3. Include the binding adapters in your layout file

```sh
<EditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="8dp"
    android:layout_marginStart="16dp"
    android:layout_marginTop="16dp"
    android:layout_marginEnd="16dp"
    android:autofillHints="example@email.com"
    android:hint="@string/email_address"
    android:inputType="textEmailAddress"
    app:validateEmpty="@{true}"
    app:validateType="@{`Email`}"
    app:validateTypeAutoDismiss="@{true}" />
```

```sh
app:validateEmpty 
app:validateType 
app:validateTypeAutoDismiss
```

These attributes here utilize our Validator library which binds and adds validation to the input fields .

### Step 4. Initialize our Validator

```sh
    // Declare our Validator class variable
    private lateinit var validator: Validator
    
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_login)
        
        // Initialize our Validator class and pass the view binding to our constructor
        // This binds our view with the binding adapters
        validator = Validator(binding)

        // Enable form validation mode: validates all inputs at once, like submit forms on web browsers
        validator.enableFormValidationMode()
        
        binding.buttonLogin.setOnClickListener {
            // Validate that our inputs are valid data
            if (validator.validate()) {
                // Submit your form with your validated input fields
            }
        }
    }
```


#### We are all set!!

Now we can enjoy databinding and validation on our input values right out of the box.

#### Other Attributes we can use

```sh
validateDate
validateMinLength
validateMaxLength
validateEmpty
validateType
```

More coming soon

### Support

<a href="https://www.buymeacoffee.com/zakayothuku" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-black.png" alt="Buy Me A Coffee" style="height: 41px !important;width: 174px !important;" ></a>

### Contributing

All our development (both new features and bug fixes) is performed in the develop branch. This way master always contains the sources of the most recently released version. Please send PRs with bug fixes to the develop branch. Documentation fixes in the markdown files are an exception to this rule. They are updated directly in master.

The develop branch is pushed to master on release.

For more details on contributing please see our contributing guide.

### License

```sh
    MIT License
    
    Copyright (c) 2020 Schatz Designs. schatzdesigns.com
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
```
