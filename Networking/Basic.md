# 🌐 Networking Concepts Cheat Sheet

## 🔹 Switch
- A switch connects multiple devices in the same network (LAN).
- It forwards data based on MAC addresses.
- Works at Layer 2 (Data Link Layer) of the OSI model.
- Example: Connects PCs, printers, and servers inside an office.

## 🔹 Router
* A router connects multiple networks together (e.g., LAN to WAN/Internet).
* Forwards data based on IP addresses.
* Works at Layer 3 (Network Layer) of the OSI model.
* Example: Your home router connects your devices to the internet.

## 🔹 Gateway
* A gateway is a device/software that translates traffic between different protocols or networks.
* In small networks, the router often acts as the default gateway (the path to outside networks).
* Example: A VoIP gateway converts voice calls into digital data packets.

## 🔹 Subnet
* A subnet (subnetwork) is a smaller portion of a larger network.
* Uses a subnet mask to define which IPs belong to the same network.
* Helps organize and optimize networks.
* Example: 192.168.1.0/24 → devices with IPs 192.168.1.1 to 192.168.1.254.

## 🔹 Firewall
* A firewall is a security system that monitors and controls incoming/outgoing traffic based on rules.
* Can be hardware or software.
* Protects against unauthorized access and attacks.
* Example: Blocking all external SSH (port 22) requests from the internet.

## 🔹 DMZ (Demilitarized Zone)
- Isolated network zone between LAN & Internet.
- Hosts **public-facing servers** (web, mail, DNS).
- Adds an extra **layer of security**.

## 🔹 IP (Internet Protocol Address)
- Unique identifier for each device on a network.
- Types: **IPv4 (32-bit)** & **IPv6 (128-bit)**.

## 🔹 Port Forwarding
* A technique to redirect traffic from one port of a public IP to a specific device/port in a private LAN.
* Used for hosting services inside a private network.
* Example: Forwarding port 80 on your router’s public IP → your internal web server 192.168.1.100:80.
    