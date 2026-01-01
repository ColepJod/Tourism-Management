# Tourism Management System (Java)

A simple console-based tourism booking application implemented in Java. It supports user registration and login, browsing international and domestic destinations, viewing hotels, selecting predefined packages, creating custom packages, a lucky-spin discount feature, booking history, and updating user details.

**Key Features**
- Register and login users
- View international and domestic destinations with descriptions and sample hotels
- Choose predefined packages (Platinum/Gold/Silver) or create a custom package
- Lucky spin discount (paid chance)
- View booking history and personal details
- Update username, password, email, and mobile

**Files**
- [tourism_main.java](tourism_main.java) — Main source file containing the entire application

**Requirements**
- Java 17 or newer (uses `Random.nextInt(origin, bound)` which requires Java 17+)

**Compile & Run**

```bash
javac tourism_main.java
java tour
```

**Notes & Known Issues**
- Mobile validation in `Customer.set()` checks `mobile.length() == 10` and `mobile.startsWith("91")` which is inconsistent (a number starting with "91" would normally be longer). You may want to revise this logic.
- `Customer.display()` prints the passport number using `username` instead of `passport_no`.
- `display_package()` reports `nights` as `(days + 1)` which may be incorrect depending on intended semantics.
- The `tourism_main.java` file contains all classes in one file and does not use packages; you can refactor into multiple files/classes for maintainability.

**Contributing**
Improvements welcome: split classes into separate files, fix validation issues, add persistent storage (file/DB), and add unit tests.

**License**
Add a license of your choice before publishing to GitHub.
