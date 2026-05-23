# ⛽ Car Fuel Management Application

<div align="center">

![Platform](https://img.shields.io/badge/Platform-Android-brightgreen?style=for-the-badge)
![Language](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge)
![Database](https://img.shields.io/badge/Database-File%20I%2FO-blue?style=for-the-badge)
![Validation](https://img.shields.io/badge/Validation-HomeAffairs%20%7C%20SAPS-red?style=for-the-badge)
![Payments](https://img.shields.io/badge/Payments-Google%20Pay%20%7C%20Debit%20Order-success?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Development-yellow?style=for-the-badge)

</div>

---

# 🚗 Car Fuel Management Application

**An app that helps South Africans buy fuel at discounted rates based on loyalty**

I built this app to solve a simple problem — fuel is expensive, and loyal customers should get better deals. The app tracks how often someone buys fuel through the platform and rewards them with big[...]

The more consistently customers use the service, the less they eventually pay for fuel.

---

# 📱 What Does This App Actually Do?

Think of it like a fuel subscription system.

A customer:

- Registers their personal details
- Registers their vehicle
- Purchases fuel once per month
- Pays back the fuel amount later
- Earns discounts for consistent repayments

At first, the customer pays more than the fuel amount. But over time, their repayment decreases until they eventually pay only 25% of the fuel price.

---

# 📉 Discount System

| Purchase Number | Repayment Amount |
|----------------|------------------|
| 1st Purchase | 125% of fuel price |
| 2nd Purchase | 118.75% |
| 3rd Purchase | 112.5% |
| 4th Purchase | 106.25% |
| ... | Continues decreasing |
| After 12 Purchases | 25% of fuel price |

✅ Customers who consistently pay on time receive better discounts.

---

# 👤 Registration Process

## Step 1 — Personal Information

The customer enters:

- Name & surname
- South African ID number
- Home address
- Vehicle registration number

---

# ✅ Validations

## 🪪 ID Number Validation

The system checks the South African ID number using a custom Home Affairs validation system.

The goal is to ensure:

- The person is a real South African citizen
- The customer can be traced

Validation is handled using Java File I/O.

---

## 🚓 Vehicle Registration Validation

The car registration is validated against:

- Traffic Department database
- SAPS stolen vehicle records

The system checks:

- If the car is roadworthy
- If the vehicle is not stolen

---

## 📍 Province Registration Validation

The registration number must match South African province formats.

Examples:

| Province | Example Format |
|----------|----------------|
| Gauteng | XX XX XX GP |
| KwaZulu-Natal | XX XX XX ZN |
| Western Cape | XX XX XX WC |
| Mpumalanga | XX XX XX MP |

The app uses Java exception handling and regex validation.

---

# 📷 Vehicle Image Capture

The system captures a picture of the car together with its registration plate.

The photo may be captured from:

- Front view
- Back view

This helps with verification and fraud prevention.

---

# 🚘 Vehicle Registration

## Car Selection

The customer chooses a vehicle from a dropdown list.

Vehicle data comes from:

- Automobile Association of South Africa (AA)

The app automatically generates:

- Fuel tank capacity
- Estimated full tank cost

---

# ⛽ Fuel Quotation System

Fuel prices are obtained from:

- PetroleumSA

The system calculates:

- Current fuel price
- Full tank cost
- Discount amount
- Total repayment amount

---

# 💳 Payment Process

Customers can choose:

- Debit Order
- Card Payment
- Google Pay
- Other electronic payment methods

The customer also selects a repayment date within 30 days.

---

# 🎯 Consistent Customer Benefits

Customers who consistently use the service receive better rewards.

## Rules

- Fuel can only be purchased once per month
- First-time customers repay 125%
- Each successful repayment earns a 6.25% discount
- Discounts improve gradually over time
- After enough consistent usage, customers eventually pay only 25%

---

# ⚠️ Non-Consistent Customer Benefits

Customers who skip months still receive smaller benefits.

| Usage Per Year | Discount |
|----------------|----------|
| 4–11 times | 2.5% |
| Less than 3 times | 1% |

Customers can improve their discount level by becoming more consistent.

---

# 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Main programming language |
| Android Studio | Development |
| XML Layouts | User interface |
| Java File I/O | Validation system |
| Regex | Registration validation |
| APIs | Payment integration |
| OOP | Business logic |

---

# 🏗️ Project Structure

```text
CarFuelManagement/
│
├── frontend/
│   ├── activities/
│   │   ├── LoginActivity.java
│   │   ├── RegisterActivity.java
│   │   ├── CarDetailsActivity.java
│   │   └── PaymentActivity.java
│   │
│   └── layouts/
│       ├── activity_login.xml
│       ├── activity_register.xml
│       ├── activity_car_details.xml
│       └── activity_payment.xml
│
├── backend/
│   ├── validation/
│   │   ├── IDValidator.java
│   │   ├── CarRegValidator.java
│   │   └── ProvinceValidator.java
│   │
│   ├── pricing/
│   │   ├── FuelPriceCalculator.java
│   │   └── DiscountCalculator.java
│   │
│   ├── data/
│   │   ├── CarModelData.java
│   │   └── FuelPriceData.java
│   │
│   └── files/
│       ├── stolen_cars.txt
│       ├── roadworthy_cars.txt
│       └── id_verification.txt
│
└── payment/
    └── PaymentAPI.java
```

---

# 🧠 Discount Calculation Logic

```java
// First purchase
double repayment = fuelPrice * 1.25;

// Discount progression
double discount = 0.0625 * monthsConsistent;
double repaymentAmount = fuelPrice * (1.25 - discount);

// Minimum repayment eventually reaches 25%
```

---

# 📚 What I Learned

Building this project taught me a lot about:

- Java File I/O
- Validation systems
- Regex patterns
- Business logic implementation
- Payment processing concepts
- Error handling
- Discount calculation systems

One of the hardest parts was getting the discount logic correct and handling all South African registration validation formats.

---

# 🚧 Challenges Faced

## Province Validation

Each province has different vehicle registration formats, so regex validation became complicated.

## File I/O Performance

Reading large text files repeatedly slows down validation. A real-world system would use databases or APIs instead.

## Discount Logic

The yearly reset and progressive discount system required careful testing to avoid calculation mistakes.

---

# 🚀 Future Improvements

Features I would add later:

- Real API integration with government systems
- Online payment gateway integration
- Push notifications
- Monthly fuel alerts
- Admin dashboard
- Cloud database
- Mobile OTP verification

---

# ▶️ How To Run The Project

1. Clone the repository

```bash
git clone https://github.com/yourusername/car-fuel-management.git
```

2. Open in Android Studio

3. Add validation text files inside the assets folder

4. Run on emulator or Android device

---

# 📂 Important Note About Data Files

The following files are mock data for academic purposes:

- stolen_cars.txt
- roadworthy_cars.txt
- id_verification.txt

In a real system, these would be replaced with secure APIs connected to government services.

---

# 👨‍💻 Developer

Built as a student Java project.

**Name:** Your Name  
**Course:** Diploma in ICT  
**Email:** your.email@example.com  
**GitHub:** github.com/yourusername

---

# ⚠️ Disclaimer

This project is for educational purposes only and is not connected to real government systems or financial institutions.

---

<div align="center">

## ☕ Built with Java, logic, debugging, and too much coffee.

</div>