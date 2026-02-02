---
📕 Courses:
  - "!!Intro to Computer Networks"
tags:
  - ComputerScience
  - ComputerScience/Networks
Date Created: 2026-01-21
---
```table-of-contents
```
---
>Section 1.1
# Network
- A group or system of *interconnected* people or things (nodes)
- **Structure**
	- connection links, in which way the nodes are connected
- **Infrastructure**
	- devices, tools, and protocols for communication
- **Purpose**
	- the purpose of the communication

# Mailing Network
## Purpose
- Delivering packages/ mail from one location to another given location's addresses
![[Pasted image 20260121145732.png]]
## Structure
- Ground transportation
- Air transportation
- Other types of transportation (maritime, train)
## Infrastructure
- Storage facility
- Road/ flight network
- Distribution centers
## Questions to Ask (resources are limited)
- How to design an effective network that could reach any location
- How to efficiently route a package from an origin to a destination?
- How to handle congestion?
- Which protocols should be followed to avoid loss and delay?
- How to secure the shipping process?

# Computer Network
- **Node**: personal devices (computers, phones, cars), servers (web, email, file, printing), network devices, networking hardware,...
	- Could be identified by a unique type of address
- Connected by a network of communication links and packet switches
- **More devices**: smart devices (Amazon Echo/ Google Home, Smart thermostat, smart lock, ...), security cameras, drones, ...
## Purpose
- Digital communication via email, instant message, video calls, etc.
- Connecting devices (printers, smart devices, etc.)
- Sharing files and remote control

# Internet
- The "Internet" refers to a worldwide network of computer networks that communicate with one another by utilizing the network protocol
## Internet Nuts and Bolts
![[Pasted image 20260121150639.png|| 600]]

# ISP, Routers, and Switches
- Mailing network analogy:
	- **ISPs** network: air, ground, and maritime
	- **Routers and Switches**: carrier facilities including local post offices
	- **Main purpose**: Allow the transmission of packets of data or information between intended nodes identified by IP addresses
## Internet Service Provider (ISP)
- ISPs are companies that provide the infrastructure to transmit data and information over the internet
	- AT&T, Comcast, Verizon
### ISP Hierarchy
- Tier 1: Global reach
	- Coverage level: international and national
- Tier 2: Connection b/w Tier 1 and 3
	- Coverage level: regional or country based
- Tier 3: Closest to the end users
	- Coverage level: local
![[Pasted image 20260121151125.png||450]]
### ISP Summary
![[Pasted image 20260121151203.png||600]]
## Internet Nuts and Bolts
- **Internet**: "network of networks"
	- Interconnected ISPs
- **protocols** control sending, receiving of messages
	- TCP, IP, HTTP, Skype, 802.11
- **Internet standards**
	- RFC: Request for comments
	- IETF: Internet Engineering Task Force
### Service View
- Infrastructure that provides services to applications:
	- Web, VoIP, email, games, e-commerce, social nets, ...
- Provides programming interface to apps
	- Hooks that allow sending and receiving app programs to "connect" to Internet
	- Provides service options, analogous to postal service
## What's a Protocol?
- **Protocols** define format, order of messages sent and received among network entities, and actions taken on message transmission, receipt
- **Network Protocols**
	- All communication activity in Internet governed by protocols
		- specific messages sent
		- specific actions taken when messages received, or other events
> Human protocol VS Computer Network protocol

![[Pasted image 20260121152016.png||450]]

---
# References
1. 