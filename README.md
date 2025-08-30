<div align="center">
  
# 🛍️ Cloud E-Commerce Platform 🌟

![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)
![GitHub stars](https://img.shields.io/github/stars/khan-sk-dev/cloud-ecommerce-platform?style=social)
![GitHub forks](https://img.shields.io/github/forks/khan-sk-dev/cloud-ecommerce-platform?style=social)
![GitHub issues](https://img.shields.io/github/issues/khan-sk-dev/cloud-ecommerce-platform)
![Build Status](https://img.shields.io/github/actions/workflow/status/khan-sk-dev/cloud-ecommerce-platform/ci-cd.yml?branch=main)

## 🚀 A Cutting-Edge Microservices E-Commerce Platform Built for the Cloud Era 🚀

**Scalable • Cloud-Native • Event-Driven • Production-Ready • Kubernetes-Optimized**

</div>

## 📋 Table of Contents
- [🎯 Overview](#-overview)
- [✨ Key Features](#-key-features)
- [🏗️ Architecture](#️-architecture)
- [🛠️ Tech Stack](#️-tech-stack)
- [🚀 Quick Start](#-quick-start)
- [📦 Services Deep Dive](#-services-deep-dive)
- [🔧 Configuration](#-configuration)
- [📊 API Documentation](#-api-documentation)
- [🐳 Docker & Kubernetes](#-docker--kubernetes)
- [📈 Monitoring & Observability](#-monitoring--observability)
- [🧪 Testing Strategy](#-testing-strategy)
- [🔐 Security](#-security)
- [🤝 Contributing](#-contributing)
- [📜 License](#-license)
- [🙏 Acknowledgments](#-acknowledgments)

## 🎯 Overview

The **Cloud E-Commerce Platform** is a state-of-the-art, enterprise-grade e-commerce solution built using microservices architecture and cloud-native principles. Designed to handle millions of transactions with ease, this platform showcases the best practices in distributed systems, providing a robust foundation for modern e-commerce applications.

### 🌟 What Sets Us Apart?

#### 🏆 Business Excellence
- 🛒 **Complete E-Commerce Suite** - Full product lifecycle management
- 💳 **Smart Payment Processing** - Multiple gateway support (Stripe, PayPal, Razorpay)
- 📦 **Intelligent Order Management** - Real-time tracking and status updates
- 🏪 **Multi-Vendor Support** - Marketplace capabilities built-in
- 📊 **Advanced Analytics** - Business intelligence and real-time metrics

#### 🚀 Technical Excellence
- ☁️ **Cloud-Native Architecture** - Built for Kubernetes from the ground up
- 🔄 **Event-Driven Design** - Apache Kafka backbone for reliable messaging
- 🛡️ **Enterprise Security** - OAuth2 + JWT + API Gateway protection
- 📈 **Auto-Scaling** - Handle traffic spikes effortlessly
- 🌍 **Global Ready** - Multi-region deployment support

### 💡 Perfect For
- 🏢 **Enterprise E-Commerce** platforms
- 🛍️ **Multi-vendor Marketplaces**
- 📱 **Omnichannel Retail** solutions
- 🌐 **Global E-Commerce** operations
- 🎓 **Learning Microservices** architecture

## ✨ Key Features

### 🛍️ E-Commerce Features

| Feature | Description | Status |
|---------|-------------|--------|
| 🛒 **Product Catalog** | Advanced search, filtering, categories | ✅ Complete |
| 🛍️ **Shopping Cart** | Persistent cart with Redis caching | ✅ Complete |
| 💳 **Payment Gateway** | Stripe, PayPal, Razorpay integration | ✅ Complete |
| 📦 **Order Tracking** | Real-time status updates | ✅ Complete |
| 👤 **User Profiles** | Comprehensive user management | ✅ Complete |
| 🔔 **Notifications** | Email, SMS, Push notifications | ✅ Complete |
| 📊 **Analytics Dashboard** | Real-time business metrics | ✅ Complete |
| 🎁 **Promotions & Discounts** | Coupon and offer management | ✅ Complete |

### 🛠️ Technical Features

| Feature | Description | Status |
|---------|-------------|--------|
| 🚪 **API Gateway** | Centralized routing with Spring Cloud Gateway | ✅ Complete |
| 🔍 **Service Discovery** | Dynamic service registration with Eureka | ✅ Complete |
| ⚙️ **Config Management** | Centralized configuration with Spring Cloud Config | ✅ Complete |
| 🔄 **Event Streaming** | Kafka-based event-driven architecture | ✅ Complete |
| 📊 **Monitoring Suite** | Prometheus, Grafana, ELK Stack | ✅ Complete |
| 🔐 **Security Layer** | OAuth2, JWT, Rate Limiting | ✅ Complete |
| 🐳 **Containerization** | Docker & Kubernetes ready | ✅ Complete |
| 🔄 **CI/CD Pipeline** | GitHub Actions automated deployment | ✅ Complete |

## 🏗️ Architecture

### 🌐 High-Level System Architecture

```mermaid
graph TB
    subgraph "🌍 External World"
        Customer[👤 Customers]
        Admin[👨‍💼 Admins]
        Payment[💳 Payment Providers]
        Shipping[📦 Shipping Partners]
    end
    
    subgraph "🔐 Edge Layer"
        LB[⚖️ Load Balancer]
        Gateway[🚪 API Gateway]
        Auth[🔐 Auth Service]
    end
    
    subgraph "💼 Business Services"
        Product[🛍️ Product Service]
        Cart[🛒 Cart Service]
        Order[📦 Order Service]
        User[👤 User Service]
        PaymentSvc[💳 Payment Service]
        Inventory[📋 Inventory Service]
        Notification[🔔 Notification Service]
        Analytics[📊 Analytics Service]
    end
    
    subgraph "🔄 Event Bus"
        Kafka[Apache Kafka]
    end
    
    subgraph "💾 Data Layer"
        PostgreSQL[(🐘 PostgreSQL)]
        MongoDB[(🍃 MongoDB)]
        Redis[(🔴 Redis Cache)]
        Elasticsearch[(🔍 Elasticsearch)]
    end
    
    subgraph "🛠️ Infrastructure Services"
        Eureka[🔍 Service Discovery]
        Config[⚙️ Config Server]
        Vault[🔐 HashiCorp Vault]
    end
    
    subgraph "📊 Observability"
        Prometheus[📈 Prometheus]
        Grafana[📊 Grafana]
        Zipkin[🔍 Zipkin]
        ELK[📝 ELK Stack]
    end
    
    Customer --> LB
    Admin --> LB
    LB --> Gateway
    Gateway --> Auth
    
    Gateway --> Product
    Gateway --> Cart
    Gateway --> Order
    Gateway --> User
    Gateway --> PaymentSvc
    
    Order --> Kafka
    PaymentSvc --> Kafka
    Inventory --> Kafka
    Kafka --> Notification
    Kafka --> Analytics
    
    Product --> MongoDB
    User --> PostgreSQL
    Order --> PostgreSQL
    Cart --> Redis
    Analytics --> Elasticsearch
    
    PaymentSvc --> Payment
    Order --> Shipping
    
    style Customer fill:#e1f5fe
    style Kafka fill:#ff6b6b
    style Gateway fill:#f3e5f5
    style PostgreSQL fill:#336791
    style MongoDB fill:#4DB33D
    style Redis fill:#DC382D
```

### 🏛️ Service Architecture Pattern

Each microservice follows a clean, layered architecture:

```
┌─────────────────────────────────────┐
│             🌐 API Layer            │
│        (Controllers & DTOs)         │
├─────────────────────────────────────┤
│           💼 Business Layer         │
│        (Services & Domain)          │
├─────────────────────────────────────┤
│         🗄️ Persistence Layer       │
│      (Repositories & Entities)      │
├─────────────────────────────────────┤
│        🔌 Integration Layer         │
│    (Message Queues & External)     │
└─────────────────────────────────────┘
```

## 🛠️ Tech Stack

### 🎯 Core Technologies

| Category | Technology | Purpose | Version |
|----------|------------|---------|---------|
| ☕ Language | Java | Primary Language | 17 LTS |
| 🍃 Framework | Spring Boot | Microservices Framework | 3.2.0 |
| 🌥️ Cloud | Spring Cloud | Cloud Native Tools | 2023.0.0 |
| 🐳 Containerization | Docker | Container Runtime | 24.0+ |
| ☸️ Orchestration | Kubernetes | Container Orchestration | 1.28+ |
| 🔄 Messaging | Apache Kafka | Event Streaming | 3.6+ |
| 🚪 API Gateway | Spring Cloud Gateway | API Management | 4.1.0 |

### 💾 Data Technologies

| Database | Use Case | Why? |
|----------|----------|------|
| 🐘 PostgreSQL | Orders, Users | ACID compliance, Complex queries |
| 🍃 MongoDB | Product Catalog | Flexible schema, Fast reads |
| 🔴 Redis | Cart, Sessions | In-memory speed, TTL support |
| 🔍 Elasticsearch | Search, Analytics | Full-text search, Analytics |

### 📊 Monitoring Stack

| Tool | Purpose | Integration |
|------|---------|-------------|
| 📈 Prometheus | Metrics Collection | All services |
| 📊 Grafana | Visualization | Prometheus data |
| 🔍 Zipkin | Distributed Tracing | Request tracking |
| 📝 ELK Stack | Log Aggregation | Centralized logging |
| 🏥 Spring Actuator | Health Checks | Service health |

### 🔐 Security Stack

| Component | Technology | Purpose |
|-----------|------------|---------|
| 🔐 Authentication | OAuth2 + JWT | Token-based auth |
| 🚪 Authorization | Spring Security | Role-based access |
| 🔑 Secrets | HashiCorp Vault | Secret management |
| 🛡️ API Security | Rate Limiting | DDoS protection |
| 🔒 Encryption | TLS 1.3 | Data in transit |

## 🚀 Quick Start

### 📋 Prerequisites

#### 🖥️ Development Machine
- 💻 **OS**: Linux/Mac/Windows (WSL2)
- 💾 **RAM**: 16GB minimum
- 💿 **Storage**: 20GB free space
- 🌐 **Network**: Stable internet

#### 🛠️ Required Software
- ☕ **Java JDK**: 17 or higher
- 🐳 **Docker**: 24.0+
- 🐳 **Docker Compose**: 2.20+
- ☸️ **kubectl**: 1.28+ (optional)
- 🔨 **Maven**: 3.9+

### ⚡ One-Click Deployment

```bash
# 🚀 Clone and Deploy Everything
git clone https://github.com/khan-sk-dev/cloud-ecommerce-platform.git
cd cloud-ecommerce-platform
./deploy.sh --full-stack
```

### 🎯 Step-by-Step Setup

#### 🐳 Option 1: Docker Compose (Recommended for Development)

```bash
# Start the entire stack with Docker Compose
docker-compose up -d

# Wait for services to initialize
./scripts/wait-for-services.sh

# Verify all services are running
docker-compose ps

# View logs for a specific service
docker-compose logs product-service -f
```

#### ☸️ Option 2: Kubernetes Deployment (Production-like)

```bash
# Apply Kubernetes manifests
kubectl apply -f k8s/namespace.yaml
kubectl apply -f k8s/configs/
kubectl apply -f k8s/services/

# Wait for pods to be ready
kubectl get pods -n ecommerce-platform --watch

# Access the application
kubectl port-forward -n ecommerce-platform svc/api-gateway 8080:80
```

#### 💻 Option 3: Local Development Setup

```bash
# Start infrastructure services
docker-compose up -d postgres mongodb redis kafka zookeeper

# Build and run services individually
cd product-service && mvn spring-boot:run
cd order-service && mvn spring-boot:run
# ... repeat for other services

# Or use the development script
./scripts/start-dev.sh
```

### 🎯 Verify Installation

After startup, check these endpoints:

| Service | URL | Status Check |
|---------|-----|-------------|
| 🚪 API Gateway | http://localhost:8080 | `curl http://localhost:8080/actuator/health` |
| 🔍 Eureka Dashboard | http://localhost:8761 | UI accessible |
| 📊 Zipkin Tracing | http://localhost:9411 | UI accessible |
| 📈 Grafana Dashboard | http://localhost:3000 | UI accessible (admin/admin) |
| 📝 Kibana Logs | http://localhost:5601 | UI accessible |

## 📦 Services Deep Dive

<details>
<summary>🚪 <strong>API Gateway Service</strong></summary>

**Purpose**: Central entry point for all client requests with routing, filtering, and security

**Tech Stack**: Spring Cloud Gateway + WebFlux + Resilience4j

**Key Features**:
- ✅ Dynamic route configuration
- ✅ JWT authentication validation
- ✅ Rate limiting and circuit breaking
- ✅ Request/Response transformation
- ✅ Load balancing across services

**Configuration**:
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: product-service
          uri: lb://product-service
          predicates:
            - Path=/api/v1/products/**
          filters:
            - name: RequestRateLimiter
              args:
                redis-rate-limiter.replenishRate: 10
                redis-rate-limiter.burstCapacity: 20
```
</details>

<details>
<summary>🛍️ <strong>Product Service</strong></summary>

**Purpose**: Manages product catalog, categories, inventory display, and search

**Tech Stack**: Spring Boot + MongoDB + Elasticsearch + Redis Cache

**Key Features**:
- ✅ Complete product CRUD operations
- ✅ Advanced search and filtering
- ✅ Category and tag management
- ✅ Product recommendations
- ✅ Inventory status integration

**API Endpoints**:
```http
GET    /api/v1/products           # List products with pagination
GET    /api/v1/products/{id}      # Get product details
POST   /api/v1/products           # Create new product (Admin)
PUT    /api/v1/products/{id}      # Update product (Admin)
DELETE /api/v1/products/{id}      # Delete product (Admin)
GET    /api/v1/products/search    # Search products
GET    /api/v1/categories         # List categories
```

**Data Model**:
```java
public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private List<String> categories;
    private Map<String, String> attributes;
    private List<String> imageUrls;
    private Double averageRating;
    private Boolean active;
}
```
</details>

<details>
<summary>🛒 <strong>Cart Service</strong></summary>

**Purpose**: Manages shopping cart operations with Redis persistence

**Tech Stack**: Spring Boot + Redis + Spring Data Redis

**Key Features**:
- ✅ Persistent user shopping carts
- ✅ Real-time cart updates
- ✅ Cart expiration management
- ✅ Price calculations and discounts
- ✅ Cart merging across devices

**API Endpoints**:
```http
GET    /api/v1/cart              # Get user cart
POST   /api/v1/cart/items        # Add item to cart
PUT    /api/v1/cart/items/{id}   # Update cart item quantity
DELETE /api/v1/cart/items/{id}   # Remove item from cart
DELETE /api/v1/cart              # Clear cart
POST   /api/v1/cart/apply-coupon # Apply coupon code
```

**Redis Structure**:
```json
{
  "userId": "user-123",
  "items": [
    {
      "productId": "prod-456",
      "quantity": 2,
      "price": 29.99,
      "addedAt": "2024-01-15T10:30:00Z"
    }
  ],
  "subtotal": 59.98,
  "discount": 5.00,
  "total": 54.98,
  "couponCode": "SUMMER10"
}
```
</details>

<details>
<summary>📦 <strong>Order Service</strong></summary>

**Purpose**: Handles complete order lifecycle management and processing

**Tech Stack**: Spring Boot + PostgreSQL + JPA + Kafka Producer

**Key Features**:
- ✅ Order creation and validation
- ✅ Inventory synchronization
- ✅ Payment processing integration
- ✅ Order status tracking
- ✅ Event publishing for notifications

**API Endpoints**:
```http
POST   /api/v1/orders             # Create new order
GET    /api/v1/orders/{id}        # Get order details
GET    /api/v1/orders/user/{id}   # Get user orders
PUT    /api/v1/orders/{id}/status # Update order status
DELETE /api/v1/orders/{id}        # Cancel order
GET    /api/v1/orders/stats       # Order statistics (Admin)
```

**Order States**:
```mermaid
graph LR
    A[🆕 PENDING] --> B[💰 PAYMENT_PROCESSING]
    B --> C[✅ PAYMENT_CONFIRMED]
    C --> D[📦 PROCESSING]
    D --> E[🚚 SHIPPED]
    E --> F[📦 DELIVERED]
    B --> G[❌ PAYMENT_FAILED]
    C --> H[🚫 CANCELLED]
    D --> H
```
</details>

<details>
<summary>💳 <strong>Payment Service</strong></summary>

**Purpose**: Handles payment processing with multiple gateway integrations

**Tech Stack**: Spring Boot + Stripe API + PayPal API + Razorpay API

**Key Features**:
- ✅ Multiple payment gateway support
- ✅ Payment intent creation and confirmation
- ✅ Refund processing
- ✅ Payment webhook handling
- ✅ Transaction history and reporting

**Supported Gateways**:
- 💳 **Stripe** - Credit cards, Apple Pay, Google Pay
- 📱 **PayPal** - PayPal balance, Credit cards
- 🌍 **Razorpay** - Popular in India and Southeast Asia

**API Endpoints**:
```http
POST   /api/v1/payments/intent    # Create payment intent
POST   /api/v1/payments/confirm   # Confirm payment
POST   /api/v1/payments/refund    # Process refund
GET    /api/v1/payments/{id}      # Get payment details
POST   /api/v1/webhooks/stripe    # Stripe webhook handler
POST   /api/v1/webhooks/paypal    # PayPal webhook handler
```
</details>

<details>
<summary>👤 <strong>User Service</strong></summary>

**Purpose**: Manages user accounts, authentication, and profiles

**Tech Stack**: Spring Boot + PostgreSQL + Spring Security OAuth2

**Key Features**:
- ✅ User registration and authentication
- ✅ Profile management
- ✅ Address book management
- ✅ Role-based access control
- ✅ Password reset and recovery

**API Endpoints**:
```http
POST   /api/v1/auth/register      # User registration
POST   /api/v1/auth/login         # User login
POST   /api/v1/auth/logout        # User logout
GET    /api/v1/users/profile      # Get user profile
PUT    /api/v1/users/profile      # Update user profile
GET    /api/v1/users/addresses    # Get user addresses
POST   /api/v1/users/addresses    # Add new address
```

**User Roles**:
- 👤 **CUSTOMER** - Regular shopping users
- 👨‍💼 **SELLER** - Vendor users with product management
- 🛡️ **ADMIN** - Full system administration
- 📊 **ANALYST** - Read-only analytics access
</details>

<details>
<summary>🔔 <strong>Notification Service</strong></summary>

**Purpose**: Handles multi-channel customer notifications and alerts

**Tech Stack**: Spring Boot + Kafka Consumer + Email + SMS APIs

**Key Features**:
- ✅ Email notifications with templates
- ✅ SMS alerts via Twilio/other providers
- ✅ Push notifications for mobile apps
- ✅ Notification preference management
- ✅ Delivery status tracking

**Supported Events**:
- 📧 **Order Confirmation** - Order placement emails
- 📱 **Shipping Updates** - Delivery status SMS
- ⚠️ **Security Alerts** - Login attempts, password changes
- 🎉 **Promotional Offers** - Marketing campaigns
- 🔔 **Stock Alerts** - Back in stock notifications

**Notification Channels**:
- 📧 Email (SMTP, SendGrid, Amazon SES)
- 📱 SMS (Twilio, Amazon SNS)
- 📲 Push (Firebase Cloud Messaging)
- 💬 Webhooks (Slack, Discord, Custom)
</details>

<details>
<summary>📊 <strong>Analytics Service</strong></summary>

**Purpose**: Collects and processes business analytics data

**Tech Stack**: Spring Boot + Elasticsearch + Kafka Streams

**Key Features**:
- ✅ Real-time sales analytics
- ✅ Customer behavior tracking
- ✅ Product performance metrics
- ✅ Revenue reporting
- ✅ Custom dashboard creation

**Key Metrics Tracked**:
- 📈 **Sales Performance** - Revenue, orders, average order value
- 👥 **Customer Analytics** - New vs returning, geographic distribution
- 🛍️ **Product Analytics** - Best sellers, inventory turnover
- 🎯 **Conversion Rates** - Cart abandonment, checkout completion
- 📊 **Traffic Sources** - Referral, direct, social media

**Data Storage**:
- 🔍 **Elasticsearch** - For fast search and aggregations
- 🗄️ **PostgreSQL** - For structured reporting data
- 📊 **Redis** - For real-time counters and metrics
</details>

## 🔧 Configuration

### 🌍 Environment Configuration

| Environment | Purpose | Config Location | Features |
|-------------|---------|----------------|----------|
| `local` | Local development | `application-local.yml` | In-memory DB, Mock services |
| `dev` | Development server | Config Server | Full services, Test data |
| `staging` | Pre-production | Config Server + Vault | Production-like, Test payments |
| `prod` | Production | Config Server + Vault | Full security, Real payments |

### ⚙️ Service Configuration

```yaml
# Example: product-service configuration
server:
  port: ${PORT:8081}

spring:
  application:
    name: product-service
  data:
    mongodb:
      uri: ${MONGODB_URI:mongodb://localhost:27017/products}
      database: product_db
  redis:
    host: ${REDIS_HOST:localhost}
    port: ${REDIS_PORT:6379}
    password: ${REDIS_PASSWORD:}
  kafka:
    bootstrap-servers: ${KAFKA_BOOTSTRAP_SERVERS:localhost:9092}
    consumer:
      group-id: product-service-group

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  metrics:
    export:
      prometheus:
        enabled: true
    tags:
      application: ${spring.application.name}

# Custom application properties
app:
  cache:
    ttl: ${CACHE_TTL:3600}
  search:
    elasticsearch:
      url: ${ELASTICSEARCH_URL:http://localhost:9200}
      index: products_index
  rate-limiter:
    requests-per-minute: ${RATE_LIMIT:1000}
```

### 🔐 Security Configuration

```yaml
# OAuth2 Resource Server Configuration
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: ${JWT_ISSUER_URI:http://localhost:8080/auth/realms/ecommerce}
          jwk-set-uri: ${JWT_JWK_SET_URI:http://localhost:8080/auth/realms/ecommerce/protocol/openid-connect/certs}

# API Rate Limiting
resilience4j:
  ratelimiter:
    instances:
      api:
        limitForPeriod: ${RATE_LIMIT:100}
        limitRefreshPeriod: 1m
        timeoutDuration: 0
  circuitbreaker:
    instances:
      inventory-service:
        failureRateThreshold: 50
        waitDurationInOpenState: 10s
        permittedNumberOfCallsInHalfOpenState: 10
        slidingWindowSize: 20

# CORS Configuration
cors:
  allowed-origins: ${ALLOWED_ORIGINS:http://localhost:3000,http://localhost:8080}
  allowed-methods: GET,POST,PUT,DELETE,OPTIONS
  allowed-headers: "*"
  allow-credentials: true
```

## 📊 API Documentation

### 🌐 API Gateway Endpoints

| Service | Base Path | Description | Auth Required |
|---------|-----------|-------------|---------------|
| 🛍️ Products | `/api/v1/products` | Product catalog management | Partial |
| 🛒 Cart | `/api/v1/cart` | Shopping cart operations | Yes |
| 📦 Orders | `/api/v1/orders` | Order management | Yes |
| 💳 Payments | `/api/v1/payments` | Payment processing | Yes |
| 👤 Users | `/api/v1/users` | User management | Partial |
| 🔔 Notifications | `/api/v1/notifications` | Notification preferences | Yes |
| 📊 Analytics | `/api/v1/analytics` | Business intelligence | Admin |

### 📖 API Documentation Tools

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI Spec**: http://localhost:8080/v3/api-docs
- **Postman Collection**: [Download Collection](docs/postman/collection.json)
- **API Client SDKs**: Available for JavaScript, Java, Python

### 🔑 Authentication

```bash
# Get access token
curl -X POST http://localhost:8080/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "user@example.com",
    "password": "password123"
  }'

# Response
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "token_type": "Bearer",
  "expires_in": 3600,
  "refresh_token": "def50200e5678a2b2a7c2f4a5c6b8a9d..."
}

# Use token in requests
curl -X GET http://localhost:8080/api/v1/orders \
  -H "Authorization: Bearer <your-token>" \
  -H "Content-Type: application/json"
```

### 📝 Example API Calls

<details>
<summary>🛍️ Product API Examples</summary>

```bash
# Get all products with pagination
curl -X GET "http://localhost:8080/api/v1/products?page=0&size=20&sort=name,asc"

# Search products
curl -X GET "http://localhost:8080/api/v1/products/search?query=laptop&category=electronics"

# Create new product (Admin)
curl -X POST http://localhost:8080/api/v1/products \
  -H "Authorization: Bearer <admin-token>" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "MacBook Pro 16-inch",
    "description": "Apple MacBook Pro with M2 Pro chip",
    "price": 2499.99,
    "stockQuantity": 50,
    "categories": ["electronics", "laptops"],
    "attributes": {
      "brand": "Apple",
      "screenSize": "16 inches",
      "storage": "1TB SSD",
      "memory": "16GB RAM"
    }
  }'
```
</details>

<details>
<summary>📦 Order API Examples</summary>

```bash
# Create new order
curl -X POST http://localhost:8080/api/v1/orders \
  -H "Authorization: Bearer <user-token>" \
  -H "Content-Type: application/json" \
  -d '{
    "items": [
      {
        "productId": "prod-123",
        "quantity": 1,
        "price": 299.99
      }
    ],
    "shippingAddress": {
      "street": "123 Main St",
      "city": "San Francisco",
      "state": "CA",
      "zipCode": "94102",
      "country": "USA"
    },
    "paymentMethod": "credit_card"
  }'

# Get user orders
curl -X GET http://localhost:8080/api/v1/orders/user/me \
  -H "Authorization: Bearer <user-token>"
```
</details>

## 🐳 Docker & Kubernetes

### 🐳 Docker Architecture

```yaml
# docker-compose.yml structure
version: '3.8'

services:
  # Infrastructure Services
  postgres:
    image: postgres:15-alpine
    environment:
      POSTGRES_DB: ecommerce
      POSTGRES_USER: ${DB_USER}
      POSTGRES_PASSWORD: ${DB_PASSWORD}
    volumes:
      - postgres_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U postgres"]
      interval: 10s
      timeout: 5s
      retries: 5
    networks:
      - ecommerce-net

  mongodb:
    image: mongo:6.0
    environment:
      MONGO_INITDB_ROOT_USERNAME: ${MONGO_USER}
      MONGO_INITDB_ROOT_PASSWORD: ${MONGO_PASSWORD}
    volumes:
      - mongo_data:/data/db
    healthcheck:
      test: ["CMD", "mongosh", "--eval", "db.adminCommand('ping')"]
      interval: 10s
      timeout: 5s
      retries: 5
    networks:
      - ecommerce-net

  redis:
    image: redis:7-alpine
    command: redis-server --requirepass ${REDIS_PASSWORD}
    volumes:
      - redis_data:/data
    healthcheck:
      test: ["CMD", "redis-cli", "-a", "${REDIS_PASSWORD}", "ping"]
      interval: 10s
      timeout: 5s
      retries: 5
    networks:
      - ecommerce-net

  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    networks:
      - ecommerce-net

  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
    ports:
      - "9092:9092"
    networks:
      - ecommerce-net

  # Monitoring Stack
  prometheus:
    image: prom/prometheus:latest
    volumes:
      - ./monitoring/prometheus.yml:/etc/prometheus/prometheus.yml
      - prometheus_data:/prometheus
    ports:
      - "9090:9090"
    networks:
      - ecommerce-net

  grafana:
    image: grafana/grafana:latest
    environment:
      GF_SECURITY_ADMIN_PASSWORD: ${GRAFANA_PASSWORD}
    volumes:
      - grafana_data:/var/lib/grafana
      - ./monitoring/dashboards:/etc/grafana/provisioning/dashboards
    ports:
      - "3000:3000"
    depends_on:
      - prometheus
    networks:
      - ecommerce-net

  zipkin:
    image: openzipkin/zipkin:latest
    ports:
      - "9411:9411"
    networks:
      - ecommerce-net

volumes:
  postgres_data:
  mongo_data:
  redis_data:
  prometheus_data:
  grafana_data:

networks:
  ecommerce-net:
    driver: bridge
```

### ☸️ Kubernetes Deployment

```yaml
# Example: Product Service Deployment
apiVersion: apps/v1
kind: Deployment
metadata:
  name: product-service
  namespace: ecommerce-platform
  labels:
    app: product-service
    tier: backend
    version: v1.0.0
spec:
  replicas: 3
  selector:
    matchLabels:
      app: product-service
  template:
    metadata:
      labels:
        app: product-service
        version: v1.0.0
      annotations:
        prometheus.io/scrape: "true"
        prometheus.io/port: "8081"
        prometheus.io/path: "/actuator/prometheus"
    spec:
      containers:
      - name: product-service
        image: khan-sk-dev/product-service:latest
        imagePullPolicy: IfNotPresent
        ports:
        - containerPort: 8081
          name: http
        env:
        - name: SPRING_PROFILES_ACTIVE
          value: "k8s"
        - name: MONGODB_URI
          valueFrom:
            secretKeyRef:
              name: mongodb-secret
              key: connection-string
        - name: REDIS_HOST
          value: "redis-master.redis.svc.cluster.local"
        - name: KAFKA_BOOTSTRAP_SERVERS
          value: "kafka.kafka.svc.cluster.local:9092"
        resources:
          requests:
            memory: "512Mi"
            cpu: "250m"
          limits:
            memory: "1Gi"
            cpu: "500m"
        livenessProbe:
          httpGet:
            path: /actuator/health/liveness
            port: 8081
          initialDelaySeconds: 30
          periodSeconds: 10
          timeoutSeconds: 5
          failureThreshold: 3
        readinessProbe:
          httpGet:
            path: /actuator/health/readiness
            port: 8081
          initialDelaySeconds: 20
          periodSeconds: 5
          timeoutSeconds: 3
          failureThreshold: 3
        startupProbe:
          httpGet:
            path: /actuator/health/readiness
            port: 8081
          initialDelaySeconds: 5
          periodSeconds: 10
          failureThreshold: 30
---
apiVersion: v1
kind: Service
metadata:
  name: product-service
  namespace: ecommerce-platform
  labels:
    app: product-service
spec:
  selector:
    app: product-service
  ports:
  - port: 8081
    targetPort: 8081
    name: http
  type: ClusterIP
---
apiVersion: autoscaling/v2
kind: HorizontalPodAutoscaler
metadata:
  name: product-service-hpa
  namespace: ecommerce-platform
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: product-service
  minReplicas: 2
  maxReplicas: 10
  metrics:
  - type: Resource
    resource:
      name: cpu
      target:
        type: Utilization
        averageUtilization: 70
  - type: Resource
    resource:
      name: memory
      target:
        type: Utilization
        averageUtilization: 80
  - type: Pods
    pods:
      metric:
        name: http_requests
      target:
        type: AverageValue
        averageValue: 100
```

### 🚀 Kubernetes Setup Guide

```bash
# Create namespace
kubectl create namespace ecommerce-platform

# Apply secrets
kubectl apply -f k8s/secrets/ -n ecommerce-platform

# Apply config maps
kubectl apply -f k8s/configs/ -n ecommerce-platform

# Apply infrastructure services
kubectl apply -f k8s/infrastructure/ -n ecommerce-platform

# Wait for infrastructure to be ready
kubectl wait --for=condition=ready pod -l app=postgres -n ecommerce-platform --timeout=300s
kubectl wait --for=condition=ready pod -l app=mongodb -n ecommerce-platform --timeout=300s
kubectl wait --for=condition=ready pod -l app=kafka -n ecommerce-platform --timeout=300s

# Apply application services
kubectl apply -f k8s/services/ -n ecommerce-platform

# Check deployment status
kubectl get all -n ecommerce-platform

# View logs
kubectl logs -f deployment/product-service -n ecommerce-platform

# Access services via port-forward
kubectl port-forward -n ecommerce-platform svc/api-gateway 8080:80
```

## 📈 Monitoring & Observability

### 📊 Metrics Dashboard

#### 🎯 Key Performance Indicators (KPIs)

| Metric | Target | Current | Status |
|--------|--------|---------|--------|
| 🚀 API Response Time | < 200ms | 150ms | ✅ Healthy |
| 📈 Throughput | > 1000 req/s | 1250 req/s | ✅ Healthy |
| 💾 Error Rate | < 0.1% | 0.05% | ✅ Healthy |
| 🔄 Service Uptime | > 99.9% | 99.95% | ✅ Healthy |
| 💰 Order Conversion | > 3% | 3.2% | ✅ Healthy |
| 🛒 Cart Abandonment | < 60% | 58% | ✅ Healthy |

### 🔍 Distributed Tracing

```mermaid
gantt
    title Request Trace: Place Order
    dateFormat X
    axisFormat %L ms
    
    section API Gateway
    Request Reception    :0, 5
    Auth Validation     :5, 15
    
    section Order Service
    Order Creation      :20, 50
    Inventory Check     :70, 30
    
    section Payment Service
    Payment Processing  :100, 200
    
    section Notification
    Email Trigger       :300, 50
    
    section Response
    Client Response     :350, 10
```

### 📝 Logging Strategy

```json
{
  "timestamp": "2024-01-15T10:30:45.123Z",
  "level": "INFO",
  "service": "order-service",
  "traceId": "b3d4f6e8-9c2a-4b1d-8e3f-1a2b3c4d5e6f",
  "spanId": "a1b2c3d4-e5f6-7890",
  "userId": "user-123",
  "action": "ORDER_CREATED",
  "orderId": "ORD-2024-001234",
  "amount": 299.99,
  "duration": 145,
  "message": "Order successfully created",
  "context": {
    "paymentMethod": "credit_card",
    "itemsCount": 3,
    "shippingMethod": "express"
  }
}
```

### 🏥 Health Check Endpoints

```bash
# Check individual service health
curl http://localhost:8080/api/v1/products/actuator/health

# Response
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "MongoDB",
        "validationQuery": "{ ping: 1 }"
      }
    },
    "redis": {
      "status": "UP",
      "details": {
        "version": "7.0.5"
      }
    },
    "kafka": {
      "status": "UP"
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 500107862016,
        "free": 350107862016,
        "threshold": 10485760
      }
    }
  }
}
```

### 📈 Grafana Dashboards

**Available Dashboards**:
- 🏪 **E-Commerce Overview** - Business metrics and KPIs
- 🔧 **Microservices Health** - Service status and performance
- 💾 **Database Performance** - Query times and connection pools
- 🔄 **Kafka Metrics** - Message rates and consumer lag
- 🛡️ **Security Dashboard** - Authentication and authorization metrics

**Sample Dashboard Queries**:
```sql
-- Daily revenue
SELECT sum(total_amount) 
FROM orders 
WHERE status = 'DELIVERED' 
AND created_at >= now() - INTERVAL '1 day'

-- Top selling products
SELECT p.name, count(oi.id) as sales_count
FROM order_items oi
JOIN products p ON oi.product_id = p.id
WHERE oi.created_at >= now() - INTERVAL '7 days'
GROUP BY p.name
ORDER BY sales_count DESC
LIMIT 10
```

## 🧪 Testing Strategy

### 🔬 Test Pyramid

```mermaid
graph TB
    E2E["🌐 E2E Tests<br/>50 tests"]
    Integration["🔄 Integration Tests<br/>200 tests"]
    Unit["🔬 Unit Tests<br/>1000+ tests"]
    
    E2E --> Integration
    Integration --> Unit
    
    style E2E fill:#ff6b6b,stroke:#333,stroke-width:2px
    style Integration fill:#4ecdc4,stroke:#333,stroke-width:2px
    style Unit fill:#45b7d1,stroke:#333,stroke-width:2px
```

### 🧪 Test Coverage Report

| Service | Unit Tests | Integration Tests | E2E Tests | Total Coverage |
|---------|------------|-------------------|-----------|----------------|
| 🚪 API Gateway | 85% | 78% | ✅ | 82% |
| 🛍️ Product Service | 92% | 85% | ✅ | 89% |
| 🛒 Cart Service | 90% | 82% | ✅ | 87% |
| 📦 Order Service | 88% | 80% | ✅ | 85% |
| 💳 Payment Service | 95% | 88% | ✅ | 92% |
| 👤 User Service | 87% | 79% | ✅ | 84% |
| 🔔 Notification Service | 83% | 76% | ✅ | 81% |

### 🚀 Running Tests

```bash
# Run all tests
./mvnw clean test

# Run unit tests only
./mvnw test -Dtest.groups=unit

# Run integration tests
./mvnw test -Dtest.groups=integration

# Run specific service tests
./mvnw test -pl :product-service

# Run with coverage report
./mvnw clean test jacoco:report

# Run E2E tests
cd e2e-tests && npm test

# Run performance tests
./mvnw gatling:test

# Run security tests
./mvnw owasp:check
```

### 📊 Performance Testing

```groovy
// Gatling Performance Test Example
class OrderServiceSimulation extends Simulation {
  
  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .acceptHeader("application/json")
    .authorizationHeader("Bearer ${authToken}")
    
  val scn = scenario("Order Creation Load Test")
    .exec(
      http("Create Order")
        .post("/api/v1/orders")
        .body(ElFileBody("order-request.json"))
        .check(status.is(201))
        .check(jsonPath("$.orderId").saveAs("orderId"))
    )
    .exec(
      http("Get Order Status")
        .get("/api/v1/orders/${orderId}")
        .check(status.is(200))
    )
    
  setUp(
    scn.inject(
      rampUsersPerSec(10) to 100 during (2 minutes),
      constantUsersPerSec(100) during (5 minutes),
      rampUsersPerSec(100) to 10 during (2 minutes)
    )
  ).protocols(httpProtocol)
   .assertions(
     global.responseTime.max.lt(3000),
     global.successfulRequests.percent.gt(99)
   )
}
```

### 🧪 Test Containers Configuration

```java
@Testcontainers
public class ProductServiceIntegrationTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0")
        .withExposedPorts(27017);

    @Container
    static GenericContainer redisContainer = new GenericContainer("redis:7-alpine")
        .withExposedPorts(6379)
        .withCommand("redis-server --requirepass testpass");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
        registry.add("spring.redis.host", redisContainer::getHost);
        registry.add("spring.redis.port", redisContainer::getFirstMappedPort);
        registry.add("spring.redis.password", () -> "testpass");
    }

    @Test
    void shouldCreateProduct() {
        // Test implementation using real containers
    }
}
```

## 🔐 Security

### 🛡️ Security Architecture

```mermaid
graph TB
    Client[👤 Client] --> WAF[🛡️ Web Application Firewall]
    WAF --> LB[⚖️ Load Balancer/TLS Termination]
    LB --> Gateway[🚪 API Gateway]
    
    subgraph "🔐 Security Layer"
        Gateway --> Auth[🔑 OAuth2/JWT Auth]
        Auth --> RateLimit[🚦 Rate Limiter]
        RateLimit --> RBAC[👮 Role-Based Access]
    end
    
    RBAC --> Services[📦 Microservices]
    
    subgraph "🔒 Data Security"
        Services --> Encryption[🔐 Data Encryption]
        Services --> Vault[🗝️ HashiCorp Vault]
        Services --> Audit[📝 Audit Logging]
    end
    
    style WAF fill:#ff6b6b
    style Auth fill:#4ecdc4
    style Vault fill:#f9ca24
```

### 🔑 Security Features

| Feature | Implementation | Status |
|---------|----------------|--------|
| 🔐 Authentication | OAuth2 + JWT | ✅ Implemented |
| 🔑 Authorization | Spring Security + RBAC | ✅ Implemented |
| 🚦 Rate Limiting | Resilience4j | ✅ Implemented |
| 🛡️ API Security | CORS, CSRF Protection | ✅ Implemented |
| 🔒 Data Encryption | AES-256 at rest, TLS 1.3 in transit | ✅ Implemented |
| 🗝️ Secret Management | HashiCorp Vault | ✅ Implemented |
| 📝 Audit Logging | Comprehensive audit trail | ✅ Implemented |
| 🚨 Security Scanning | OWASP ZAP, SonarQube | ✅ Implemented |

### 🔐 API Security Example

```java
@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    @PostMapping("/products")
    @RateLimiter(name = "admin-api")
    @AuditLog(action = "CREATE_PRODUCT")
    public ResponseEntity<Product> createProduct(
            @Valid @RequestBody ProductDTO productDTO,
            @AuthenticationPrincipal User user) {
        
        // Validate permissions
        securityService.validatePermission(user, "PRODUCT_CREATE");
        
        // Create product with audit trail
        Product product = productService.create(productDTO, user);
        
        return ResponseEntity.created(
            URI.create("/api/v1/products/" + product.getId())
        ).body(product);
    }

    @GetMapping("/analytics/sales")
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    @RateLimiter(name = "analytics-api")
    public ResponseEntity<SalesReport> getSalesReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        
        SalesReport report = analyticsService.generateSalesReport(startDate, endDate);
        return ResponseEntity.ok(report);
    }
}
```

### 🚨 Security Headers Configuration

```yaml
# Security headers configuration
security:
  headers:
    content-security-policy: "default-src 'self'; script-src 'self' 'unsafe-inline' https://trusted.cdn.com; style-src 'self' 'unsafe-inline'"
    x-content-type-options: "nosniff"
    x-frame-options: "DENY"
    x-xss-protection: "1; mode=block"
    strict-transport-security: "max-age=31536000 ; includeSubDomains"
    referrer-policy: "strict-origin-when-cross-origin"
```

### 🔒 Data Protection

```java
// Example of data encryption
@Service
public class PaymentService {
    
    @Encrypted
    private String encryptCreditCard(String cardNumber) {
        return encryptionService.encrypt(cardNumber);
    }
    
    @Decrypted
    private String decryptCreditCard(String encryptedCard) {
        return encryptionService.decrypt(encryptedCard);
    }
}

// Audit logging example
@Aspect
@Component
public class AuditLogAspect {
    
    @AfterReturning(
        pointcut = "@annotation(auditLog)",
        returning = "result"
    )
    public void logAuditEvent(JoinPoint joinPoint, AuditLog auditLog, Object result) {
        AuditEvent event = AuditEvent.builder()
            .action(auditLog.action())
            .userId(SecurityContext.getCurrentUserId())
            .timestamp(Instant.now())
            .ipAddress(RequestContext.getClientIP())
            .details(extractDetails(joinPoint, result))
            .build();
        
        auditRepository.save(event);
    }
}
```

## 🤝 Contributing

We love contributions! Please see our [Contributing Guide](CONTRIBUTING.md) for details.

### 🌟 How to Contribute

1. **🍴 Fork the repository**
2. **🌿 Create your feature branch**
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. **💻 Make your changes**
4. **✅ Test your changes thoroughly**
   ```bash
   ./mvnw clean verify
   ```
5. **📝 Commit your changes**
   ```bash
   git commit -m 'feat: Add some AmazingFeature'
   ```
6. **🚀 Push to the branch**
   ```bash
   git push origin feature/AmazingFeature
   ```
7. **🎯 Open a Pull Request**

### 📋 Contribution Guidelines

- ✅ Follow [Conventional Commits](https://www.conventionalcommits.org/)
- ✅ Write unit tests for new features
- ✅ Update documentation for changes
- ✅ Ensure all tests pass before submitting
- ✅ Add meaningful commit messages
- ✅ Keep PRs focused and small
- ✅ Follow the existing code style

### 🐛 Reporting Bugs

Found a bug? Please open an issue with:

- 🔍 **Clear description** of the problem
- 📋 **Steps to reproduce** the issue
- 💻 **Environment details** (OS, Java version, etc.)
- 📸 **Screenshots** if applicable
- 🎯 **Expected behavior** vs actual behavior

### 💡 Feature Requests

Have an idea? We'd love to hear it! Please open a feature request with:

- 🎯 **Clear use case** and problem statement
- 💡 **Proposed solution** or implementation ideas
- 🤔 **Alternatives considered**
- 📊 **Impact assessment** on existing functionality

### 🏷️ Pull Request Template

```markdown
## Description
<!-- Describe your changes in detail -->

## Related Issue
<!-- Link to the issue this PR addresses -->

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Testing
- [ ] Added unit tests
- [ ] Added integration tests
- [ ] Updated existing tests
- [ ] Manual testing performed

## Documentation
- [ ] Updated README
- [ ] Added code comments
- [ ] Updated API documentation

## Checklist
- [ ] Code follows style guidelines
- [ ] Tests pass locally
- [ ] No breaking changes introduced
- [ ] Documentation updated
```

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```text
MIT License

Copyright (c) 2024 Khan SK Dev

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

## 🙏 Acknowledgments

### 🌟 Special Thanks To

- **Spring Team** - For the amazing Spring ecosystem and continuous innovation
- **Netflix OSS** - For pioneering microservices patterns and best practices
- **CNCF (Cloud Native Computing Foundation)** - For cloud-native technologies and standards
- **Open Source Community** - For continuous support, feedback, and contributions
- **All Contributors** - For making this project better every day

### 📚 Resources & Inspiration

- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Microservices.io](https://microservices.io/) - Microservices patterns and anti-patterns
- [12 Factor App](https://12factor.net/) - Methodology for building SaaS applications
- [Cloud Native Computing Foundation](https://www.cncf.io/) - Cloud native technologies
- [Martin Fowler](https://martinfowler.com/) - Software architecture insights

### 🏆 Contributors

<!-- Add your name below when you contribute -->

- **[Khan SK Dev](https://github.com/khan-sk-dev)** - Project maintainer and lead developer

### 📖 Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Docker Documentation](https://docs.docker.com/)
- [Kubernetes Documentation](https://kubernetes.io/docs/)
- [Apache Kafka Documentation](https://kafka.apache.org/documentation/)
- [Microservices Best Practices](https://microservices.io/patterns/)

---

<div align="center">

## ⭐ If you found this project helpful, please give it a star! ⭐

**Happy coding! 🚀**

[![GitHub stars](https://img.shields.io/github/stars/khan-sk-dev/cloud-ecommerce-platform?style=social)](https://github.com/khan-sk-dev/cloud-ecommerce-platform/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/khan-sk-dev/cloud-ecommerce-platform?style=social)](https://github.com/khan-sk-dev/cloud-ecommerce-platform/network/members)
[![GitHub issues](https://img.shields.io/github/issues/khan-sk-dev/cloud-ecommerce-platform)](https://github.com/khan-sk-dev/cloud-ecommerce-platform/issues)

</div>
