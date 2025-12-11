# Study Room Application - MVP Concept Description

**Version:** 1.0 (Draft)  
**Date:** December 9, 2025  
**Status:** Concept Definition - Ready for Development Planning

---

## 1. Core MVP Hypothesis/Goal

**Primary Hypothesis:**  
*"CSUMB students will actively use integrated Pomodoro timers within voice-enabled study communities, and visible peer study activity (timer usage, completion notifications) will increase both individual accountability and sustained platform engagement compared to using standalone timer apps."*

**What We're Testing:**
- **Tool Consolidation Value (PRD Section 2.1):** Will students prefer using timers embedded in their study community vs. separate apps?
- **Accountability Through Visibility (PRD Section 2.1):** Does seeing peers' timer activity motivate continued use and discipline?
- **Voice Channel Study Value (PRD Section 6):** Will students use voice channels for silent co-working/study sessions?

**Success Would Mean:**
- Students create communities and actively use them for study sessions
- The Pomodoro timer becomes a regular part of their study routine within the platform
- Peer visibility creates motivation (measured through qualitative feedback and return behavior)

---

## 2. Target Audience (MVP Subset)

**Primary Early Adopters:**  
CSUMB (California State University Monterey Bay) college students, specifically:

- **Demographics:** Undergraduate students (ages 18-24)
- **Behavioral Profile:** 
  - Currently juggling multiple study tools/apps (PRD Section 1)
  - Study alone or in small informal groups (2-5 people)
  - Familiar with Discord/Slack-style interfaces (PRD Section 3)
  - Experience procrastination or difficulty maintaining study discipline
- **Study Context:** 
  - Taking challenging courses requiring focused study time
  - Need accountability but lack structured study groups
  - Prefer studying with low-key peer presence vs. complete isolation

**Secondary Early Adopters (Opportunistic):**  
Self-learners, certification prep students, and students from other institutions who:
- Discover the platform through word-of-mouth from CSUMB students
- Share similar needs for accountability and focused study tools
- Will provide additional data points on product-market fit beyond student demographic

**Why This Segment:**
- **CSUMB focus** provides geographic/institutional concentration for tight feedback loops and targeted recruitment
- College students are the primary persona from PRD Section 3
- Small group size (2-10) reduces technical complexity while maintaining social dynamics
- This segment experiences the core problems most acutely (PRD Section 1)
- **Inclusive positioning** allows broader tester pool without diluting primary hypothesis
- Core value proposition (accountability + integrated tools) is universal across learning contexts

---

## 3. Problem Solved (MVP Focus)

**Specific Problem (from PRD Section 1 & User Stories Section 4):**

*"CSUMB students studying alone lack both external accountability and the motivating presence of peers, leading to procrastination and reduced study effectiveness. They currently juggle separate apps (Discord for communication + standalone Pomodoro timers), creating friction and reducing the sense of 'studying together' even when coordinating remotely."*

**MVP Solution Focus:**
- Provide a single platform where small study groups can:
  - Gather in voice channels for silent co-working (reducing isolation)
  - Use synchronized Pomodoro timers (tool consolidation)
  - See when peers complete study sessions (accountability through visibility)
  - Communicate in text channels without switching apps

**Out of Scope for MVP:** Advanced study techniques (flashcards, mind mapping), LMS integration, large community management, advanced moderation, verified organizations

---

## 4. Minimum Feature Set (Prioritized - "IN" vs. "OUT")

### IN SCOPE - Essential for Hypothesis Testing

#### 4.1 User Account & Authentication (PRD Section 5.1)
- **User Registration:** Username/email + password creation
- **Basic Global Profile:** 
  - Username
  - Profile picture (upload)
  - **Learning context field:** Dropdown selection:
    - CSUMB Student
    - Other College/University Student (with text field to specify institution)
    - High School Student
    - Self-Learner / Lifelong Learner
    - Professional / Certification Prep
    - Other
  - Optional: Major/field of study (text input)
  - NO: Banner images, extensive bio, verified organizations
- **Email Verification:** Optional confirmation email (not required to use platform)
- **Data Collection:** Store school/domain info for future analysis, no hard enforcement

#### 4.2 Community Management (PRD Section 5.3, UX Section 3.0)
- **Create Community:** 
  - Community name, simple description
  - Private only (invite-link access) - NO public discovery needed for MVP
  - Owner role established automatically
- **Join Community:**
  - Via invite link only
  - Simple rules acceptance page (UX Flow A, Steps 9-11)
  - Maximum 10 members per community (MVP constraint)
- **Community Structure:**
  - ONE default text channel (#general)
  - ONE default voice channel (General Voice)
  - Owner can create up to 2 additional channels (1 text, 1 voice max)
  - NO: Channel categories, complex permissions, role management beyond Owner/Member

#### 4.3 Voice Channels (PRD Section 6, UX Section 3.2)
- **Join/Leave Voice Channel:**
  - Click to join (UX Flow F)
  - Audio-only by default (mic on, video OFF)
  - Max 5 users per voice channel (reduced from PRD's 15 for MVP)
  - Join/leave audio cues
- **Basic Controls:**
  - Mute/unmute microphone
  - Deafen (mute all audio)
  - Leave channel
  - NO: Video toggle, screen sharing, chat overlay (these are OUT)
- **Voice Channel Display:**
  - Simple list of participants with avatars
  - Speaking indicator (visual border when talking)
  - Timer indicator icon if channel has active timer

#### 4.4 Text Channels (PRD Section 5.5, UX Section 3.1)
- **Basic Messaging:**
  - Send text messages
  - Message history (last 100 messages, scrollable)
  - Timestamp + username display
  - NO: Rich formatting, markdown, emojis, reactions, file uploads, replies/threads
- **Achievement Notifications (Simplified):**
  - System messages when users complete Pomodoro sessions
  - Format: "[Username] completed a Pomodoro session! 🎯"
  - Posted automatically to #general text channel
  - NO: Custom accountability cards, goal tracking, reminders

#### 4.5 Pomodoro Timer - MVP CORE (PRD Section 7, UX Flows B & C)
- **Timer Characteristics:**
  - Fixed intervals: 25 min work / 5 min break / 15 min long break (after 4 sessions)
  - NO customization in MVP
- **Personal Timer (UX Flow B):**
  - Start from Study Tools sidebar (always accessible)
  - Timer modal in top-right of main content area
  - Countdown display with session type indicator
  - Cannot be hidden/minimized while running
- **Shared Timer (UX Flow C):**
  - ONLY available when user is in a voice channel
  - User starts timer → prompt: "Share with voice channel?" [Yes/No]
  - If Yes: Notification sent to voice channel members
  - Members can accept/decline join invitation
  - Timers sync across all participants
  - ONLY timer creator controls progression (continue/end)
- **Timer Completion Notification:**
  - Full-screen modal with background blur (cannot dismiss without action)
  - Options: [Continue to Break] or [End Timer]
  - On completion, achievement notification posted to #general
- **Timer Constraints:**
  - One active timer per user maximum
  - Joining new timer ends current timer (with warning modal)

#### 4.6 Basic Layout & Navigation (UX Sections 1.1-1.2)
- **Left Sidebar:** Community list (icons only)
- **Middle Sidebar:** Channel list for selected community (text + voice channels)
- **Main Content:** Channel view (text or voice)
- **Right Sidebar:** Study Tools (collapsed by default)
  - Expandable to show "Start Pomodoro Timer" button
  - NO: Reminders, stats, other tools
- **Top Navigation:**
  - Community/channel name
  - User profile icon (top-left corner)
  - Settings access
  - NO: Friends, DM, Search/Discovery pages

#### 4.7 Essential Settings (UX Section 3.9 - Minimal subset)
- **User Settings:**
  - Change username
  - Change password
  - Upload/change profile picture
  - Log out
  - NO: Privacy settings, notification preferences, appearance customization
- **Voice Settings:**
  - Select microphone input device
  - Select audio output device
  - Volume sliders (input/output)
  - Test microphone button

---

### OUT OF SCOPE - Explicitly Excluded from MVP

#### Social Features (PRD Section 5.2)
- ❌ Friends system
- ❌ Direct messages (DMs)
- ❌ User profiles beyond basic info
- ❌ Friend requests/management

#### Advanced Community Features
- ❌ Public communities
- ❌ Community discovery/search (UX Section 3.5)
- ❌ Complex role/permission system (Admin, Moderator - only Owner role in MVP)
- ❌ Community settings page (UX Section 3.8)
- ❌ Invite management UI (just generate one permanent link)
- ❌ Member management (kick/ban)

#### Text Channel Advanced Features (PRD Section 5.5)
- ❌ Rich text formatting (bold, italic, markdown)
- ❌ Emojis and GIFs
- ❌ Reactions
- ❌ File uploads (images, documents, media)
- ❌ Code blocks with syntax highlighting
- ❌ Message replies/threading
- ❌ Message editing/deletion
- ❌ Message search
- ❌ Pinned messages

#### Voice Channel Advanced Features (PRD Section 6)
- ❌ Video toggle/video calls
- ❌ Screen sharing
- ❌ Chat overlay in voice channels
- ❌ More than 5 users per channel

#### Accountability Features Beyond Timer (PRD Section 8)
- ❌ Accountability cards (admin-created goals)
- ❌ Personal reminders system
- ❌ Manual goal tracking
- ❌ Study time statistics/analytics
- ❌ Achievement badges/streaks

#### Study Tools (Beyond Pomodoro)
- ❌ Active recall tools
- ❌ Flashcards
- ❌ Mind mapping
- ❌ Feynman technique templates

#### Integrations (PRD Post-MVP)
- ❌ Canvas LMS
- ❌ Google Classroom
- ❌ Spotify
- ❌ Google Calendar

#### Polish/Nice-to-Haves
- ❌ Onboarding tutorial
- ❌ Help documentation
- ❌ Keyboard shortcuts
- ❌ Notification preferences
- ❌ Theme customization (use default only)
- ❌ Mobile responsive design (desktop only)

---

## 5. Key Constraints (MVP Specific)

### Technical Constraints
- **Platform:** Web application only (desktop browsers: Chrome, Firefox, Safari)
- **No mobile:** Desktop/laptop only - responsive design out of scope
- **Real-time Technology:** 
  - WebSocket for text messaging
  - WebRTC for voice (using existing library like PeerJS or Daily.co to reduce complexity)
- **No Video:** Reduces bandwidth/complexity significantly
- **File Storage:** NO file uploads in MVP (reduces infrastructure needs)

### User Constraints
- **Community Size:** Maximum 10 members per community
- **Voice Channel Size:** Maximum 5 concurrent users per voice channel
- **Channel Limits:** Maximum 3 channels total per community (1 text default + 2 optional)
- **Message History:** Last 100 messages per channel only
- **Primary Target:** CSUMB students (focused recruitment and primary metrics analysis)
- **Secondary Users:** Self-learners and other students accepted (opportunistic data collection)
- **No Hard Verification:** School/context field collected but not enforced - enables easy scaling

### Feature Constraints
- **Timer Only:** Pomodoro timer is the ONLY study tool
- **No Moderation:** No kick/ban, no content moderation tools (rely on small group trust)
- **No Discovery:** Private communities only, no search/browse functionality
- **Single Role:** Only Owner/Member distinction (no Admin, Moderator)

### Time/Resource Constraints
- **Development Timeline:** [TO BE DETERMINED - but assume 8-12 weeks for small team]
- **Team Size:** [TO BE DETERMINED - but design assumes 2-3 developers]
- **Infrastructure Budget:** Minimal - free tier services where possible

---

## 6. Success Metrics (Initial Ideas for Hypothesis Validation)

### Primary Metrics (Hypothesis Validation)

**Tool Consolidation Hypothesis:**
- **Timer Adoption Rate:** % of community members who start at least one Pomodoro timer within first 3 study sessions
- **Timer Completion Rate:** % of started timers that reach completion (not abandoned)
- **Multi-Session Usage:** % of users who complete 3+ Pomodoro sessions within first 2 weeks

**Accountability Hypothesis:**
- **Shared Timer Rate:** % of timers started as "shared" in voice channels vs. personal
- **Return Rate After Seeing Peer Activity:** % of users who return within 24 hours after seeing peer completion notifications
- **Qualitative Feedback:** User interviews asking: "Did seeing others' timer activity motivate you?" (Target: 70%+ say yes)

**Voice Channel Study Value:**
- **Voice Channel Usage:** Average time spent in voice channels per study session
- **Silent Co-working Adoption:** % of voice channel time with minimal speaking (indicates successful silent study use)
- **Voice + Timer Correlation:** % of timer sessions started while in voice channel

### Secondary Metrics (Engagement Indicators)

- **Community Formation:** Number of communities created by CSUMB students
- **Community Activity:** Average messages per community per week
- **Retention:** 
  - Day 7 retention rate
  - Day 30 retention rate
- **Session Frequency:** Average study sessions per user per week

### Qualitative Learning Goals

- **Exit Interviews/Surveys (10-15 users):**
  - What value did the integrated timer provide vs. standalone apps?
  - Did peer visibility impact your study motivation?
  - What was missing that prevented more frequent use?
  - Would you pay for this / recommend to friends?

### Failure Signals (Would Invalidate Hypothesis)

- Timer adoption < 30% after 2 weeks
- Timer completion rate < 40%
- Users report "didn't feel different from using timer app + Discord separately"
- Voice channels remain empty (< 20% of timer sessions involve voice)

---

## 7. MVP User Journey Summary (End-to-End)

**Happy Path - First-Time User:**

1. **Registration** → User arrives, creates account (username/email/password), adds profile pic + CSUMB tag
2. **Community Creation/Join** → User either:
   - Creates new community (gives it name, gets invite link) OR
   - Joins via friend's invite link → accepts community rules
3. **Explore Interface** → User sees default #general text channel, sees General Voice channel
4. **Start First Session:**
   - User joins General Voice channel (just them, or 1-2 friends already there)
   - User expands Study Tools sidebar
   - User clicks "Start Pomodoro Timer"
   - System asks: "Share with voice channel?" → User selects Yes
   - Friends in voice receive notification to join timer
5. **Study Session:**
   - Timer counts down in corner of screen
   - User can mute/unmute mic as needed
   - Can send text messages in #general to coordinate
6. **Timer Completion:**
   - Full-screen modal appears: "Pomodoro complete! Take a 5 min break?"
   - User selects [Continue to Break]
   - Achievement notification posts in #general: "Alex completed a Pomodoro! 🎯"
   - Other users see this message
7. **Return Behavior:**
   - User feels motivated seeing peer completion notifications
   - User returns next day/week to study with same group
   - Pattern repeats, building habit

---

## 8. Open Questions for Development Planning Phase

1. **WebRTC Implementation:** Use existing service (Daily.co, Agora) vs. native WebRTC? (Trade-off: cost vs. control)
2. **Message Storage:** How long to retain text messages? (Currently: last 100 per channel)
3. **Invite Link Security:** Single permanent link or expiring links? (Currently: single permanent for simplicity)
4. **Timer Synchronization:** How to handle timer sync edge cases (user loses connection mid-timer)?
5. **Voice Quality:** What's acceptable quality/latency for MVP? (Currently targeting <200ms)
6. **User Feedback Collection:** How do we systematically gather qualitative feedback during MVP? (In-app survey? Email? Calendly interviews?)
7. **User Segmentation Analysis:** How do we track and compare behavior across different user types (CSUMB vs. other students vs. self-learners) in analytics?

---

## 9. What This MVP WILL and WON'T Prove

### ✅ This MVP WILL Help Us Learn:

- Whether students actually prefer integrated timers over separate apps
- If peer visibility creates meaningful accountability
- Whether voice channels serve as effective silent co-working spaces
- If small study communities form naturally around this tool
- What friction points exist in the core experience
- Whether the value proposition resonates with college students

### ❌ This MVP WON'T Prove:

- Whether large communities (50-100 members) can be managed
- If advanced study tools (flashcards, etc.) add value
- Whether public discovery/search drives community growth
- If LMS integration is critical
- Whether the business model is viable (no monetization tested)
- If high school students or organizations would adopt
- Whether Discord users would fully switch platforms

---

## 10. Next Steps (Development Planning Phase)

Once this concept is validated:

1. **Technical Architecture Planning:**
   - Define tech stack (React? Vue? Backend framework?)
   - Plan WebRTC implementation approach
   - Design database schema for minimal feature set
   - Identify third-party services needed

2. **Design & Prototyping:**
   - Create low-fidelity wireframes for 7 core screens
   - Define visual design system (colors, typography, components)
   - Build clickable prototype for user testing

3. **Development Roadmap:**
   - Break features into 2-week sprints
   - Identify MVP Phase 1 (most essential) vs. Phase 2 (can launch without)
   - Define testing/QA approach

4. **Go-to-Market Plan:**
   - Recruit initial 20-30 CSUMB student testers
   - Plan feedback collection approach
   - Define success criteria for moving beyond MVP

---

**Document Status:** ✅ Ready for Development Planning  
**Last Updated:** December 9, 2025  
**Next Review:** After initial stakeholder feedback