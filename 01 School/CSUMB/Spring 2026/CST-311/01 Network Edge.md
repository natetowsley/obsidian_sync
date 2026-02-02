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
>Section 1.2
# A Closer Look at Network Structure
- Network edge
	- hosts: clients and servers
	- servers often in data centers
- Access networks, physical media
	- wire, wireless communication links
- Network core:
	- Interconnected routers
	- Network of networks

# Types of Internet Service
- Cable Internet
	- Uses coaxial cable
- Fiber Internet
	- Uses fiber optic cable
- Digital Subscriber Line (DSL)
	- Uses the telephone line
- Satellite Internet
	- Uses geostationary satellites
- Dial-Up Internet
	- Around 1990s, uses your existing phone line
	- Not "always on"
## Cable Internet
- Coaxial cable:
	- It's the same cable that delivers cable television to a home
		- Fast and reliable, consistently delivering advertised speeds
		- Widely available and is often consumers' top pick for internet service
![[Pasted image 20260126140825.png||200]]
## Fiber Internet
- Fiber optic cable
	- Fiber optic cable made from strands of glass to transmit data at the speed of light
	- Highest speed
	- Fiber broadband is available to about 39% of the U.S. population
## Digital Subscriber Line (DSL)
- Use **existing** telephone line to central office DSLAM
	- data over DSL phone line goes to Internet
	- voice over DSL phone line goes to telephone net
## Satellite Internet
- Uses geostationary satellites to send and receive data between your home and the internet
- Because data must travel to space and back, it has the highest latency, or delay, of all connection types
- Additional factors: weather and how busy the network is at any given time
- Rural areas are places served by slower dial-up, DSL, or mobile internet plans
- Satellite to ground station to home
### Starlink
- Starlink is a satellite internet service operated by SpaceX

# Access Networks and Physical Media
- Q: How to connect end systems to edge routers?
	- residential access nets
	- institutional access networks (school, company)
	- mobile access networks
- Keep in mind:
	- bandwidth (bits per second) of access network?
	- shared or dedicated?
## Access Network: Home Network
![[Pasted image 20260126141511.png||400]]
### Modem (Modulator-demodulator)
- The modem translates the data from your ISP into a format that your home network devices can use
- A router is a device that creates a local area network (LAN)
	- The router connects to your modem, and then to your devices, such as computers, laptops, smartphones, and tablets
### Modem and Router Combo
- Modem and router combo:
	- Becoming increasingly common
	- A convenient solution, for one because it takes up less space than two separate units
	- Can include wireless access point
#### Connecting to modem directly not recommended, always use router
### Switch VS Router
- **Switches** connect all the devices, including computers, printers, and servers, in a small business network
- **Routers** can connect multiple switches, and their respective networks, to form a larger network
![[Pasted image 20260126142137.png]]
- **Switches** work excellently for networks where multiple devices need a connection within a limited range
- Internet **routers** work well for homes or offices to connect to the internet where many devices may require a connection to a WAN
- In consumer products, switch and router can be combined into one device (with the modem), so a router might have a switch built in, but a router **IS NOT** a switch
![[Pasted image 20260126142351.png]]

# Internet Structure: Network of Networks
- End systems connect to Internet via access ISPs (Internet Service Providers)
	- Residential, company and university ISPs
- Access ISPs in turn must be interconnected
	- So that any two hosts can send packets to each other
- Resulting network of networks is very complex
	- Evolution was driven by economics and national policies
## Enterprise Access Networks
![[Pasted image 20260126142811.png||550]]
- Typically used in companies, universities, etc.
- 10 Mbps, 100Mbps, 1Gbps, 10Gbps transmission rates
- Today, end systems typically connect into Ethernet switch
## Wireless Access Networks
- Shared *wireless* access network connects end system to router
	- via base station aka "access point"
![[Pasted image 20260126142946.png||500]]
## Transmission Rate / Bandwidth
- Host sending function:
	- Takes application message
	- Breaks into smaller chunks, known as packets, of length *L* bits
	- Transmits packet into access network at transmission rate *R*
		- link transmission rate, aka link capacity, aka link bandwidth
	- Standard Unit: *bit/sec*
		- A link with a bandwidth of 5Mb/sec can transmit data with maximum of 5 megabits in 1 second
### Why Break a Message into Packets?
- Optimize the use of channel capacity available in networks and minimizes the time it takes for data to pass across the network
- Best way to divide data into packages?
	- Packets have varying sizes depending on the speed of the network and the overall size of the file
	- Can determine which packet size will be used during transmission by requesting both the sender and the receiver to send the maximum packet size they can transmit

# Units and Conversions To Remember
## Data
- ***Data*** is measured in *bits*
	- Alternative Units: Kb (kilobits), B (byte), KB (kilobytes), Mb (Megabits), MB, GB, TB, PB
- 1 byte = 8 bits
- 1 Kb = 1000 bits = $10^3$ bits; !KB = 1000 bytes
- 1 Mb = $10^6$; 1MB = $10^6$ bytes
- 1 Gb = $10^9$ bits; 1GB = $10^9$ bytes
## Bandwidth
- **Bandwidth** is measured in *bits/sec*
	- Alternative Units: bps (bits/sec), Kbps (kilobits/sec) KBps (kilobytes/sec), etc
	- 1 Kbps = 1000 bits/sec = $10^3$ bps; 1 KBps = 1000 bytes/sec
	- 1 Mbps = $10^6$ bps; 1MB = $10^6$ bytes/sec
	- 1 Gbps = $10^9$ bps ...
## Time
- **Time** is measured in *seconds*
- 1 s = 1000 ms = $10^3$ ms

- When working on problems
	- Can choose to work with any units but try to choose the units that do not make the numbers too long or too short
	- Being consistent with the chosen units
	- Must convert the answer to the asking unit
- Do not confuse Mb (megabits) with MB (megabytes)
	- 1 byte = 8 bits
	- 1 MB = 8 Mb

# Speed VS Bandwidth
- Download/ Upload speed: how fast data can be transferred from the Internet/ your computer to your computer/ the Internet in a second
- Bandwidth: link transmission rate/ link capacity
	- Can be compared to the maximum amount of water that can flow through a water pipe
	- Higher capacity, more data can pass through in one second
- Bandwidth is commonly shared between subscribers
	- The more subscribers, the slower data will be uploaded and downloaded
	- Other factors might affect speed: type of hardware, location, etc.
- Bandwidth is your maximum possible speed
- Speed is what your actually getting
## Download Speed and Upload Speed
- Download/Upload speed: How fast data can be transferred from the Internet/ your computer to you computer/ the Internet in a second
- Why are upload speeds slower than download speeds?
	- Most high-speed Internet connections, including cable modems and DSL, are *asymmetric*. They are designed to provide much better speed for downloading than uploading
	- Since most users spend much more time downloading (which includes viewing web pages or multimedia files) than they do uploading.
- Some providers start offering internet with relatively same download and upload speeds

# Delay/ Latency
- The time taken by the entire message/ package to reach its destination after the initial bit is sent out from the source
	- Important metric to measure network performance
- Latency = **transmission delay** + **propagation delay** + **queuing delay** + **processing delay**
## Processing Delay and Queuing Delay
- **Processing delay** is the time it takes routers to process the packet header
- **Queuing delay** is the time a job waits in a queue until it can be executed
## Transmission Delay
- Time needed to push all the packet bits on the transmission link
- Mainly depends upon the bandwidth (R)
![[Pasted image 20260126144745.png]]
- EX: transmitting 20 Mb at 5 Mbps takes 4 seconds
$$20 (bits)/5(bits/sec) = 4(sec)$$
## Data Travels a Distance - Propagation Delay
- Data must be moved over a physical distance
- Time it takes for one bit to travel from one end of the link to the other
	- How much data is sent doesn't affect propagation delay
- The bits travel in the form of electromagnetic signals, the speed is determined by the medium through which they pass
	- Speed of light or fraction of speed of light
![[Pasted image 20260126144942.png]]
---
# References
1. 