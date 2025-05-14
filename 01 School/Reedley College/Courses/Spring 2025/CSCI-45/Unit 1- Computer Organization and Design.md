---
Date Created: 2025-01-13T13:08
Favorite: false
📕 Courses:
  - "[[!!Computer Architecture and Organization]]"
---
###### tags: #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#1.1]]
    - [[#Introduction]]
        - [[#Terabytes(TB) and Other Sizes]]
- [[#1.2]]
    - [[#Eight Great Ideas in Computer Architecture]]
        - [[#Design for Moore’s Law]]
        - [[#Use Abstraction to Simplify Design]]
        - [[#Make the Common Case Fast]]
        - [[#Performance via Parallelism]]
        - [[#Performance via Pipeline]]
        - [[#Performance via Prediction]]
        - [[#Hierarchy of Memories]]
        - [[#Dependability via Redundancy]]
- [[#1.3]]
    - [[#Below Your Program]]
        - [[#From a High Level Language to the Language of Hardware]]
- [[#1.4]]
    - [[#Under the Covers]]
        - [[#Organization of a Computer]]
        - [[#The graphics display]]
        - [[#Opening The Box]]
        - [[#A Safe Place for Data]]
- [[#1.5]]
    - [[#Technologies for Building Processors and Memory]]
- [[#1.6]]
    - [[#Performance]]
        - [[#CPU performance and its factors]]
        - [[#The Classic CPU Performance Equation]]
- [[#1.7]]
    - [[#The Power Wall]]
- [[#1.8]]
    - [[#The Sea Change: The Switch from Uniprocessors to Multiprocessors]]
- [[#1.9]]
    - [[#Benchmarking the Intel Core i7]]
- [[#1.10]]
    - [[#Fallcies and Pitfalls]]
        - [[#Amdahl’s Law]]
---
# 1.1
## Introduction
- Types of computers
    - **PC:** A computer designed for use by an individual, usually incorporating a graphics display, a keyboard, and a mouse
    - **Server**: A computer used for running larger programs for multiple users, often simultaneously, and typically accessed only via a network
    - **Supercomputer:** A class of computers with the highest performance and cost; they are configured as servers and typically cost tens to hundreds of millions of dollars
    - **Embedded computer:** A computer inside another device used for running one predetermined application or collection of software
- As time goes on, personal mobile devices(PMDs) have become increasingly popular, and outpace PCs today
    - **Personal Mobile Devices(PMDs):** Small wireless devices to connect to the internet; they rely on batteries for power, and software is installed by downloading apps
    - Smart phones/ tablets
- Taking over from conventional servers is Cloud Computing which relies on giant datacenters that are now known as **Warehouse Scale Computers(WSCs)**
    - **Cloud Computing:** Large collections of servers that provide services over the Internet; some providers rent dynamically varying numbers of servers as a utility
    - **Software as a Service(Saas):** Delivers software and data as a service over the Internet, usually via a thin program such as a browser that runs on local client devices, instead of binary code that must be installed, and runs wholly on that device
        - Web serch/ social networking
### Terabytes(TB) and Other Sizes
![[image 13.png|image 13.png]]
  
# 1.2
## Eight Great Ideas in Computer Architecture
### Design for Moore’s Law
- **Moore’s Law** states that integrated curcuit resources double every 18-24 months
    - This law covers the idea that resources available per chip can easily double or quadruple between the start and finish of a project, and architects must anticipate where the technology will be when the design finishes
### Use Abstraction to Simplify Design
- **Abstraction** is a technique used to characterize the design of hardware and software at different levels of representation
    - Lower level details are hidden to offer a simpler model at higher levels
### Make the Common Case Fast
- Making the **common case** fast will often enhance performance better than optimizing the rare case
    - Common case is often simpler than rare case too, making it easier to enhance
### Performance via Parallelism
- Since the dawn of computing, computer architects have offered designs that get more performance by computing operations in **parallel**
### Performance via Pipeline
- **Pipelining** moves multiple operations through hardware units that each do a piece of an operation, akin to water flowing through a pipeline
### Performance via Prediction
- **Prediction** being the idea that, in some cases it can be faster on average to guess and start working rather than wait until you know for sure
    - Assuming that a misprediction is not too expensive and your prediction is relatively accurate
### Hierarchy of Memories
- The **Hierarchy of Memories** adresses conflicting demands of fast, large and cheap memory, with the fastest, smallest, and most expensive memory per bit at the top of the hierarchy and the slowest, largest, and cheapest per bit at the bottom
### Dependability via Redundancy
- Since any physical device can fail, we make systems **dependable** by including redundant components that can take over when a failure occurs and to help detect failures.
  
# 1.3
## Below Your Program
- **Systems Software:** Software that provides services that are commonly useful, including operating systems, compiler, loaders, and assemblers
- **Operating System:** Supervising program that manages the resources of a computer for the benefit of the programs that run on that computer
    
    - Handles basic input and output operations
    - Allocates storage and memory
    - Provides for protected sharing of the computer among multiple applications using it simultaneously
    
    ![[image 1 10.png|image 1 10.png]]
    
- **Compiler:** A program that translates high-level language statements into assembly language statements
### From a High Level Language to the Language of Hardware
- Computers cannot understand out language, and must be spoken to in **binary**
    - **Binary digit:** Also called a **bit**. One of the two numbers in base 2 (0 or 1) that are the components of information
    - **Instruction:** A command that computer hardware understands and obeys
- The first programmers coded in binary, then coded in new notations that were translated to binary by hand. When this became tiresome, a software that translated this new notation to binary was made, called an _**assembler**_
    - **Assembler:** A program that translates a symbolic version of instructions into the binary version
    - **Assembly Language:** A symbolic representation of machine instructions
    - **Machine Language:** A binary representation of machine instructions
- **High-Level Programming Language:** A portable language such as C, C++, Java, or Visual Basic that is composed of words and algebraic notation that can be translated by a compiler into assembly language
  
# 1.4
## Under the Covers
- **Input Device:** A mechanism through which the computer is fed information, such as a keyboard
- **Output Device:** A mechanism that conveys the result of a computation to a user, such as a display, or to another computer
### Organization of a Computer
![[image 2 9.png|image 2 9.png]]
### The graphics display
- **Liquid Crystal Display(LCD):** A display technology using a thin layer of liquid polymers that can be used to transmit or block light according to whether a charge is applied
- **Active Matrix Display:** A liquid crystal display using a transistor to control the transmission of light at each individual pixel
- **Pixel:** The smallest individual picture element. Screens are composed of hundreds of thousands to millions of pixels, organized in a matrix
### Opening The Box
- **Integrated Circuit:** Also called a **chip**. A device combining dozens to millions of transistors
- **Central Processor Unit(CPU):** Also called **processor**. The active part of the computer, which contains the datapath and control which adds numbers, tests numbers, signals I/O devices to activate, and so on
- The CPU is made up of two main components, the “brawn” and “brain” of the processor
    - **Datapath:** The component of the processor that performs arithmetic operations
    - **Control:** The component of the processor that commands the datapath, memory, and I/O devices according to the instructions of the program
- **Memory:** The storage area in which programs are kept when they are running and that contains the data needed by the running programs
- **Dynamic Random Access Memory(DRAM):** Memory built as an integrated circuit, it provides random access to any location. Access times are 50 nanoseconds and cost per gigabyte in 2012 was $5 to $10
- **Cache Memory:** A small, fast memory that acts as a buffer for a slower, larger memory
- **Static Random Access Memory(SRAM):** Also memory built as an integrated circuit, but faster and less dense that DRAM
### A Safe Place for Data
- **Volatile Memory:** Storage, such as DRAM, that retains date only if it is receiving power
- **Nonvolatile Memory:** A form of memory that retains data even in the absence of a power source and that is used to store brograms between runs. A DVD disk is nonvolatile
- **Main Memory:** Also called **primary memory**. Memory used to hold programs while they are runnin; typically consists of DRAM in today’s computers
- **Secondary Memory:** Nonvolatile memory used to store programs and data between runs; typically consists of flash memory in PMDs and magnetic disks in servers
- **Magnetic Disk:** Also called a hard disk. A form of nonvolatile memory composed of rotating platters coated with a magneric recording material. Because they are rotating mechanical devices, acces times are about 5 to 20 miliseconds and cost per gigabyte in 2012 was $0.05 to $0.10
- **Flash Memory:** A nonvolatile semiconductor memory. It is cheaper and slower that DRAM but more expensive per bit and faster that magnetic disks. Access times are about 5 to 50 microseconds and cost per gigabyte in 2012 was $0.06 to $0.12
# 1.5
## Technologies for Building Processors and Memory
- **Transistor:** An on/off switch controlled by an electric signal
- **Very large-scale integrated (VLSI) circuit:** A device containing hundreds of thousands to millions of transistors
- **Silicon**: A natural element that is a semiconductor
    - **Semiconductor:** A substance that does not conduct electricity well
    - With a special chemical process, it is possible to add materials to silicon that allow tiny areas to transform into one of three devices
        - Excellent conductors of electricity (using either microscopic copper or aluminum wire)
        - Excellent insulators from electricity (like plastic sheathing or glass)
        - Areas that can conduct or insulate under special conditions (as a switch)
- **Wafer:** A slice from a silicon ingot no more than 0.1 inches thick, used to create chips
- **Die**: The individual rectangular sections that are cut from a wafer more informally known as chips
![[image 3 8.png|image 3 8.png]]
- **Yield:** The percentage of good dies from the total number of dies on the wafer
![[image 4 7.png|image 4 7.png]]
  
# 1.6
## Performance
- **Response Time:** The total time required for the computer to complete a task, including disk accesses, memory accesses, I/O activities, operating system overhead, CPU execution time, and so on(**Execution time**)
- **Throughput:** Another measure of performance, it is the number of tasks completed per unit time (**Bandwidth**)
- PIn discussing a computer design, we often want to relate the performance of two different computers quantitatively. We will use the phrase “X is n times faster than Y” -or equivalently “X is n times as fast Y” -to mean
![[image 5 7.png|image 5 7.png]]
- If X is n times as fast as Y, then the execution time on Y is n times as long as it is on X:
![[image 6 5.png|image 6 5.png]]
- **CPU execution time:** Also called **CPU time**. The actual time the CPU spends computing for a specific task
- **User CPU time:** The CPU time spent in a program itself
- **System CPU time:** The CPU time spent in the operating system performing tasks on behalf of the program
- **Clock Cycle:** Also called **tick, clock tick, clock periof, clock,** or **cycle**. The time for one clock period, usually of the processor clock, which runs at a constant rate.
- **Clock period:** The length of each clock cycle
### CPU performance and its factors
![[image 7 4.png|image 7 4.png]]
![[image 8 2.png|image 8 2.png]]
### The Classic CPU Performance Equation
![[image 9 2.png|image 9 2.png]]
![[image 10 2.png|image 10 2.png]]
![[image 11 2.png|image 11 2.png]]
  
# 1.7
## The Power Wall
- Processors lack of increasing clock rate for years is due to them being too difficult to cool
![[image 12 2.png|image 12 2.png]]
- **Dynamic energy** is energy that is consumed when transistors switch states from 0 to 1 and vice versa.
    - Dynamic energy depends on the capacitive loading of each transistor and the voltage applied
![[image 13 2.png|image 13 2.png]]
- Energy of a pulse during the logic transition (0 → 1, 1 → 0) ⬇️
![[image 14.png]]
- Power required per transistor is just the product of energy of a transition and the frequency of transitions ⬇️
![[image 15.png]]
  
# 1.8
## The Sea Change: The Switch from Uniprocessors to Multiprocessors
- To combat the decline in growth of single processors, chips would be made with multiple processors (cores) per chip
![[image 16.png]]
  
# 1.9
## Benchmarking the Intel Core i7
- **Workload:** A set of programs run on a computer that is either the actual collection of applications run by a user or constructed from real programs to approximate such a mix. A typical workload specifies both the programs and the relative frequencies
- **Benchmark:** A program selected for use in comparing computer performance
- SPECINTC2006 benchmarks running on a 2.66GHz Intel Core i7 920 (COD Figure 1.18)
![[image 17.png]]
- To simplify the marketing of computers, SPEC decided to report a single number summarizing all 12 integer benchmarks. Dividing the execution time of a reference processor by the execution time of the evaluated computer normalizes the execution time measurements; this normalization yields a measure, called the SPECratio, which has the advantage that bigger numeric results indicate faster performance
![[image 18.png]]
  
# 1.10
## Fallcies and Pitfalls
- **Pitfall:** Expecting the improvement of one aspect of a computer to increase the overall performance by an amount proportional to the size of the improvement
- Improvement is affected by how much a feature is used
![[image 19.png]]
### Amdahl’s Law
- A rule stating that the performance enchancement possible with a given improvement is limited by the amount that the improved feature is used. It is a quantitative version of the law of diminishing returns
![[image 20.png]]
- **Million instructions per second(MIPS):** A measurement of program execution apeed based on the number of millions of instructions
    - MIPS is computed as the instruction count divided by the product of the execution time and 10^6
![[image 21.png]]