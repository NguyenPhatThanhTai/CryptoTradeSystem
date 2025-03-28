
# Crypto Trading System

A simple **crypto trading system** built with **Spring Boot** and an **in-memory H2 database**. The system allows users to trade **Bitcoin (BTC/USDT)** and **Ethereum (ETH/USDT)**.

## Structure

src
 └── main
     └── java
         └── com
             └── aquariux
                 └── cryptotradesystem
                     ├── controller       # Controller classes (API endpoints)
                     ├── model            # Entity classes (e.g., Wallet, TradingHistory)
                     ├── repository       # JPA repositories
                     ├── service          # Business logic
                     └── dto              # Data transfer objects (e.g., WalletResponseDTO)
     └── resources
         ├── application.properties  # Application configuration
         └── data.sql               # Initial data script for H2 database
 └── target                        # Compiled classes (generated after build)


## Technologies Used
- **Spring Boot** (Java)
- **JPA / Hibernate** for database interaction
- **H2 Database** (in-memory for development)
- **Lombok** for boilerplate code reduction
- **feign** api template

## Setup Instructions

1. **Clone the repository:**

```bash
git clone https://github.com/NguyenPhatThanhTai/CryptoTradeSystem.git
cd CryptoTradeSystem
```

2. **Install dependencies:**

```bash
mvn clean install
```

3. **Run the application:**

```bash
mvn spring-boot:run
```

4. **Access H2 Console (optional for debugging):**

Go to [http://localhost:8080/h2-console](http://localhost:8080/h2-console) and use the following connection details:

- JDBC URL: `jdbc:h2:mem:cryptosystem`
- User: `sa`
- Password: (leave blank)

---

## API Endpoints

### 1. **POST /api/trade**
- **Purpose**: Execute a trade (buy or sell)
- **Request Body**:
  ```json
  {
    "userId": 1,
    "symbol": "BTCUSDT",
    "type": "BUY",
    "quantity": 0.01
  }
  ```
- **Response**:
  ```json
  {
    "status": 200,
    "message": "Trade executed successfully for BTCUSDT",
    "data": null
  }
  ```

---

### 2. **GET /api/trade/history/{userId}**
- **Purpose**: Get trading history for a user
- **Response**:
  ```json
  {
    "status": 200,
    "message": "Success",
    "data": [
      {
        "id": 1,
        "userId": 1,
        "symbol": "BTCUSDT",
        "type": "BUY",
        "price": 30000.0,
        "quantity": 0.01,
        "time": "2025-03-28T12:45:30"
      },
      {
        "id": 2,
        "userId": 1,
        "symbol": "ETHUSDT",
        "type": "SELL",
        "price": 2000.0,
        "quantity": 0.5,
        "time": "2025-03-27T10:15:00"
      }
    ]
  }
  ```

---

### 3. **GET /api/wallet/{userId}**
- **Purpose**: Get wallet balance for a user
- **Response**:
  ```json
  {
    "status": 200,
    "message": "Success",
    "data": {
      "usdt": 49876.4,
      "btc": 0.01,
      "eth": 0.0
    }
  }
  ```

---
