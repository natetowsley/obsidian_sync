---
tags:
  - CTI
Date Created:
---
```table-of-contents
```
---
# Day 1: Environment Setup
> A recap of day 1, where I started, how I got my environment set up
- Forked [OpenEnergyDashboard](https://github.com/OpenEnergyDashboard/OED) repository on GitHub
	- [My Fork](https://github.com/natetowsley/OED/tree/development?tab=readme-ov-file)
- Downloaded WSL to device (windows subsystem for Linux)
- Cloned repo to directory within ubuntu file partition (Linux virtual disk)
- Downloaded necessary VSCode extensions
	- Remote Development + extension packs
		- WSL
		- Dev Containers
		- Remote - SSH
		- Remote - Tunnels
	- Container Tools (Docker and Podman support)
- Installed Docker Desktop

## VSCode Environment
- VSCode must be opened through ubuntu
	- In Ubuntu terminal, go to directory of cloned repo
	- Once there run:
```bash
code .
```
- If successful, explorer in VSCode will read OED [WSL: Ubuntu]
- Then rebuild in container

CURRENTLY AT Install and run OED in a terminal
---
# References
1. 