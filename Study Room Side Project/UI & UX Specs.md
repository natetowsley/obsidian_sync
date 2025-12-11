# Study Room Application - UX & UI Specifications

**Version:** 1.0 (Draft)  
**Last Updated:** December 9, 2025  
**Status:** In Development - Based on PRD v1.0

---

## 1. Information Architecture

### 1.1 Screen/Page Map with Hierarchy

```
Study Room Application
│
├── Global Navigation (Top Navbar - Left Section)
│   ├── Profile Page
│   ├── Friends Page
│   ├── DM Page
│   ├── Search/Discovery Page
│   └── Settings Page
│
├── Community Context (When in a community)
│   ├── Community List (Left Sidebar - always visible)
│   ├── Channel List (Middle Sidebar - collapsible)
│   │   ├── Text Channels
│   │   └── Voice Channels
│   └── Main Content Area
│       ├── Text Channel View
│       ├── Voice Channel View
│       └── Community Welcome/Rules Page (first-time entry)
│
├── Direct Messaging Context
│   ├── Community List (Left Sidebar - visible)
│   ├── DM List (Main Content Area)
│   └── DM Conversation View (Main Content Area)
│
└── Discovery/Search Context
    ├── Community List (Left Sidebar - visible)
    └── Search Results/Featured Communities (Main Content Area)
```

### 1.2 Primary Layout Structure

```
┌─────┬──────────┬────────────────────────────────────────┬──────────┐
│ Profile Friends│         Page Title                      │     Help │
│ DM Search Settings                                       │          │
├─────┼──────────┼────────────────────────────────────────┼──────────┤
│ Com │ Channels │                              ┌─────────┐│ Study   │
│ mun │  List    │                              │ Timer   ││ Tools   │
│ ity │ (collap  │      Main Content Area       │ Modal   ││ (expand │
│ List│  sible)  │                              └─────────┘│  able)  │
│     │          │                                          │         │
│     │          │                                          │         │
└─────┴──────────┴──────────────────────────────────────────┴─────────┘
```

**Layout Zones:**

1. **Top Left Navbar** (spans Community List + Channel List width)
   - Profile, Friends, DM, Search, Settings navigation
   - Always visible, context-independent

2. **Top Center/Right Bar** (spans Main Content Area + Study Tools width)
   - Center: Current page title
   - Right: Help button (positioned above Study Tools)

3. **Left Sidebar - Community List**
   - Always visible across all views
   - Shows all communities user has joined
   - Community icons/thumbnails (Discord-style)
   - Persists when viewing DMs, Search, Profile, etc.

4. **Middle Sidebar - Channel List**
   - Visible when: User is in a community
   - Hidden when: DM view, Search view, Profile view, Settings view
   - Collapsible: Can be manually collapsed/expanded
   - Shows text and voice channels for selected community

5. **Main Content Area**
   - Primary workspace for all content
   - Displays: Text channels, Voice channels, DMs, Search results, Profile, Settings
   - Timer modal floats in top-right corner of this area

6. **Right Sidebar - Study Tools**
   - Default state: Collapsed (slim bar with expand icon)
   - Available on: ALL pages/views
   - Expandable on user action
   - Contains: Pomodoro timer controls, reminder creation (MVP)

### 1.3 Responsive Behavior Guidelines

**Target Platform:** Desktop/Laptop only (medium to large screens)

**Collapse Priority (as window shrinks horizontally):**
1. Channel List (middle sidebar) disappears first
2. Community List (left sidebar) disappears second
3. Main Content Area remains (highest priority)
4. Study Tools sidebar follows same collapse pattern

**Collapsed Menu Behavior:**
- Collapsed menus can be manually expanded by user
- When expanded in limited space, they overlay the main content area
- User can toggle them on/off as needed

**Voice Channel Responsive Adaptations:**
- Video tiles/avatars shrink and reflow dynamically
- Layout adjusts to keep all participants visible on screen
- Bottom control bar always remains visible (never auto-hides)

---

## 2. Core User Flows

### 2.1 Primary User Journeys

#### Flow A: First-Time User Registration & Community Join

**Step 1:** User arrives at Study Room landing page  
**Step 2:** User creates account (username, password)  
**Step 3:** User sets up global profile (profile picture, banner, tags/interests)  
**Step 4:** User navigates to Search/Discovery page  
**Step 5:** User browses featured communities or searches by tags  
**Step 6:** User clicks on community card  
**Step 7:** Community details modal appears (banner, description, tags, member count)  
**Step 8:** User clicks "Join" button  
**Step 9:** User redirected to Community Welcome/Rules page  
**Step 10:** User must accept community rules to proceed  
**Step 11:** User enters community, lands in #general text channel

**Decision Points:**
- User can skip profile setup (optional fields)
- User can browse without joining (public communities visible)
- User must accept rules (no decline option - mandatory gate)

#### Flow B: Starting a Personal Pomodoro Timer

**Step 1:** User is in any view (text channel, voice channel, DM, etc.)  
**Step 2:** User expands Study Tools sidebar (right side)  
**Step 3:** User sees "Pomodoro Timer" option with description  
**Step 4:** User clicks "Start Pomodoro Timer"  
**Step 5:** Timer modal appears in top-right of main content area  
**Step 6:** Timer displays: "Pomodoro Timer" title, countdown (25:00), "until next break" text  
**Step 7:** Timer counts down, modal color indicates work period  
**Step 8:** When timer reaches 0:00, full-screen blur notification appears  
**Step 9:** Notification congratulates user, prompts: [Continue to Break] or [End Timer]  
**Step 10:** If continue → 5-minute break starts (modal color changes)  
**Step 11:** If end → Timer modal disappears

**Decision Points:**
- User must acknowledge timer completion (forced interaction)
- User chooses to continue or end at each interval
- Timer cannot be hidden while running

#### Flow C: Starting a Shared Pomodoro Timer in Voice Channel

**Step 1:** User is in a voice channel with other participants  
**Step 2:** User expands Study Tools sidebar  
**Step 3:** User clicks "Start Pomodoro Timer"  
**Step 4:** System detects user is in voice channel  
**Step 5:** Prompt appears: "Share timer with channel members?" [Yes] [No]  
**Step 6:** If Yes → Timer starts for user, notifications sent to other voice channel members  
**Step 7:** Other members receive prompt: "User X started a Pomodoro timer. Join?" [Yes] [No]  
**Step 8:** Members who accept see timer modal appear on their screen  
**Step 9:** All participants' timers sync and count down together  
**Step 10:** When timer completes, all participants see full-screen notification  
**Step 11:** Only timer creator's response advances timer to next stage  
**Step 12:** If creator continues → All participants' timers continue to break  
**Step 13:** If creator ends → All participants' timers end, notification sent

**Edge Case - Multiple Timers:**
- User can only have ONE active timer at any time
- If user attempts to join new timer while one is active:
  - Warning modal appears: "Joining will end your current timer. Continue?" [Yes] [No]
  - If Yes → Current timer terminates, user joins new timer
  - If No → User remains with current timer

#### Flow D: Adding Friends & Starting a DM

**Step 1:** User clicks on another user anywhere in app (channel, voice call, etc.)  
**Step 2:** User card modal appears (banner, avatar, username, bio, tags, study status)  
**Step 3:** User clicks "Add Friend" button  
**Step 4:** Friend request sent (pending state)  
**Step 5:** Recipient receives notification  
**Step 6:** Recipient can Accept or Deny from Friends page  
**Step 7:** If accepted → Users become friends  
**Step 8:** User navigates to DM page (top navbar)  
**Step 9:** User clicks [+] button in top-right of DM page  
**Step 10:** Recipient selector appears with search bar  
**Step 11:** User searches or selects from recommendations (friends + server mutuals)  
**Step 12:** User selects one or multiple recipients (group chat support)  
**Step 13:** DM conversation opens in main content area

**Alternative Path - DM Request to Non-Friend:**
- If selecting server mutual (not friend): DM request sent
- Recipient sees message preview and can Accept (allow DM) or Deny
- If accepted → DM conversation opens for both parties

#### Flow E: Creating & Managing Accountability Cards (Admin)

**Step 1:** Admin user is in a text channel  
**Step 2:** Admin expands Study Tools sidebar  
**Step 3:** Admin sees "Create Accountability Card" option (visible only to Admin+)  
**Step 4:** Admin clicks to create card  
**Step 5:** Form appears (Google Forms style) with fields:
   - Title (required)
   - Description
   - Deadline (date/time)
   - Additional options
**Step 6:** Admin submits form  
**Step 7:** Accountability card appears embedded in text channel message flow  
**Step 8:** Card is highlighted/emphasized for all channel members  
**Step 9:** Members see card with [Accept] [Deny] options  
**Step 10:** If member accepts:
   - Card remains visible
   - Highlight disappears for that user
   - User added to participant list on card
**Step 11:** If member denies:
   - Card disappears entirely from that user's view
   - Decision is final (no undo)

#### Flow F: Joining a Voice Channel

**Step 1:** User clicks on voice channel in channel list  
**Step 2:** System checks for microphone/camera permissions  
**Step 3:** If permissions not granted:
   - Permission request modal appears
   - User must grant access to proceed
   - If denied → User cannot join, returns to previous view
**Step 4:** If permissions granted:
   - User joins voice channel (no preview/lobby)
   - Video off by default, audio on
   - Audio cue plays for all participants (join sound)
**Step 5:** Main content area switches to voice channel view  
**Step 6:** User sees video tiles/avatars of participants (Zoom-style grid)  
**Step 7:** Bottom control bar visible: Mute, Deafen, Leave, Chat, Video Toggle, Screen Share  
**Step 8:** Study Tools sidebar remains available (collapsed by default)

**Exiting Voice Channel:**
- User clicks "Leave" button
- Audio cue plays for remaining participants (leave sound)
- User returns to previous view (text channel or last page)

#### Flow G: Community Discovery & Search

**Step 1:** User clicks "Search" in top navbar  
**Step 2:** Main content shows initial state:
   - Featured communities (curated list)
   - Category tiles (clickable)
   - Search bar at top
**Step 3:** User can:
   - **Option A:** Click category tile → Filters results by that category
   - **Option B:** Enter keyword in search bar → Shows matching communities
   - **Option C:** Apply filters without keyword (filter by member count, tags, etc.)
**Step 4:** Results display as community cards showing:
   - Community banner
   - Small logo
   - Name
   - Tags
**Step 5:** User clicks on community card  
**Step 6:** Modal appears center-screen with full community details:
   - Large banner
   - Logo
   - Name and description
   - Tags
   - Member count
   - [Join] button (for public communities)
**Step 7:** User clicks [Join]  
**Step 8:** User redirected to Community Welcome/Rules page  
**Step 9:** User must accept rules  
**Step 10:** User enters community (#general channel)

**Private Communities:**
- Not shown in search results
- Only accessible via invite link
- Invite link flow: Click link → Community details modal → Join (if invited) → Rules page → Enter

### 2.2 Error States & Recovery Paths

#### Error: Timer Completion Notification Not Acknowledged
**Scenario:** User's timer completes but user doesn't interact with notification  
**Handling:** Notification remains on screen (blocks all content) until user responds  
**Recovery:** User must choose [Continue] or [End Timer] to dismiss

#### Error: Voice Channel Permission Denied
**Scenario:** User attempts to join voice channel but denies mic/camera permissions  
**Handling:** Permission request modal appears with explanation  
**Recovery:** User can retry and grant permissions, or cancel and return to previous view  
**Future:** Link to settings/help for troubleshooting permissions

#### Error: DM to Non-Friend Denied
**Scenario:** User attempts to DM server mutual, recipient denies request  
**Handling:** Sender receives notification: "DM request declined"  
**Recovery:** Sender cannot retry immediately (prevents spam)

#### Error: Community Rules Not Accepted
**Scenario:** User joins community but doesn't accept rules  
**Handling:** User stuck on Welcome/Rules page, cannot access channels  
**Recovery:** User must accept rules to proceed, or leave community

#### Error: No Active Timer When Trying to Join Group Timer
**Scenario:** User tries to join shared timer with no current timer active  
**Handling:** Direct join (no warning needed)  
**Recovery:** N/A - smooth path

#### Error: File Upload Exceeds Size Limit
**Scenario:** User attempts to upload file larger than allowed size  
**Handling:** Error message appears: "File too large. Maximum size: [X]MB"  
**Recovery:** User can select different file or compress/resize original

---

## 3. View Specifications

### 3.0 Channel List Organization (Middle Sidebar)

**Layout Structure:**
```
┌──────────────────────┐
│ Community Name    [⚙]│
├──────────────────────┤
│ TEXT CHANNELS        │
│ # general            │
│ # announcements 🔒   │
│ # study-group        │
│ # homework-help      │
│                      │
│ VOICE CHANNELS       │
│ 🔊 General          │
│ 🔊 Focus Room  (3)  │
│ 🔊 Study Session    │
│                      │
│ [+] (if Admin+)      │
└──────────────────────┘
```

**Organization Pattern (Discord-style):**
- Text channels grouped under "TEXT CHANNELS" header
- Voice channels grouped under "VOICE CHANNELS" header  
- Each group can be collapsed/expanded (click header)
- Text channels prefixed with # icon
- Voice channels prefixed with 🔊 icon
- Active voice channels show participant count in parentheses: (3)
- Restricted channels show lock icon 🔒
- Channels ordered by creation date by default
- Admins can drag-and-drop to reorder

**Channel List States:**
- **Unread text channel:** Bold channel name or white dot
- **@Mention in channel:** Red badge with mention count
- **Active voice channel:** Green text color
- **Currently viewing:** Highlighted background
- **Hover:** Background color change, shows settings gear for Admin+

**Admin Controls:**
- [+] button at bottom to create new channel
- Right-click channel → Edit, Delete, Copy Link, Permissions
- Gear icon [⚙] next to community name → Community Settings

### 3.1 Community Text Channel View

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ # channel-name                              [?] Help   │
├────────────────────────────────────────────────────────┤
│                                                         │
│  [Message History - Scrollable Area]                   │
│                                                         │
│  User Avatar | Username | Timestamp                    │
│               Message content here...                   │
│               [Inline image/video/file if attached]    │
│                                                         │
│  User Avatar | Username | Timestamp                    │
│               Message content with **markdown**         │
│                                                         │
│  ┌──────────────────────────────────────────────────┐ │
│  │ [ACCOUNTABILITY CARD - HIGHLIGHTED]              │ │
│  │ Title: Complete Biology Chapter 5                │ │
│  │ Deadline: Friday, Dec 15                         │ │
│  │ Participants: [User1] [User2] [User3]            │ │
│  │                    [Accept] [Deny]               │ │
│  └──────────────────────────────────────────────────┘ │
│                                                         │
├────────────────────────────────────────────────────────┤
│ [+] [Bold] [Italic] [Code] [Markdown]                 │
│ ┌────────────────────────────────────────────────────┐│
│ │ Type a message...                                  ││
│ │                                                    ││
│ └────────────────────────────────────────────────────┘│
└────────────────────────────────────────────────────────┘
```

**Component Hierarchy:**
- **Channel Header Bar**
  - Channel name with # icon (or lock icon if restricted)
  - Help button (right-aligned)
  
- **Message History Area**
  - Scrollable container
  - Messages displayed chronologically (oldest to newest, scroll to bottom for latest)
  - Each message contains:
    - User avatar (left)
    - Username
    - Timestamp
    - Message content (text, markdown, embeds, reactions)
    - Hover state: 3-dot menu appears (right side of message line)
    - Right-click menu: Add reaction, Reply, Copy, Delete (if own message or mod+)
  
- **Special Message Types:**
  - **Accountability Cards:** Embedded in message flow, visually distinct (card container)
    - Highlighted border/background until user responds
    - Shows title, description, deadline, participant list
    - [Accept] [Deny] buttons for members
  - **Replied Messages:** Indented with visual connection line to parent message
  - **Media Messages:** Images/videos display inline, files show as download cards

- **Message Composer (Bottom)**
  - Formatting toolbar: Attach file, Bold, Italic, Underline, Code, Markdown toggle
  - Text input area (expandable as user types)
  - Character/line count (if applicable)
  - Markdown preview card (GitHub-style, toggle Raw/Preview)

**State Variations:**
- **Empty State (No Messages):** "No messages yet. Start the conversation!"
- **Loading State:** Skeleton loaders for messages while fetching history
- **Read-Only Channel:** Composer disabled, message: "You don't have permission to send messages"
- **Unread Indicator:** When scrolled up, "New Messages" divider appears at unread line

### 3.2 Voice Channel View

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ 🔊 voice-channel-name                       [?] Help   │
├────────────────────────────────────────────────────────┤
│                                                         │
│  ┌──────────┐  ┌──────────┐  ┌──────────┐            │
│  │  User 1  │  │  User 2  │  │  User 3  │            │
│  │  Video   │  │  Video   │  │  Video   │            │
│  │  Tile    │  │  Tile    │  │  Tile    │            │
│  └──────────┘  └──────────┘  └──────────┘            │
│                                                         │
│  ┌──────────┐  ┌──────────┐                           │
│  │  User 4  │  │  User 5  │                           │
│  │  Avatar  │  │  Avatar  │                           │
│  │ (no vid) │  │ (no vid) │                           │
│  └──────────┘  └──────────┘                           │
│                                                         │
├────────────────────────────────────────────────────────┤
│  [🎤] [🔇] [📹] [🖥️] [💬] [📞]                        │
│  Mute Deafen Video Screen  Chat Leave                  │
└────────────────────────────────────────────────────────┘
```

**Component Hierarchy:**
- **Channel Header Bar**
  - Voice channel name with speaker icon (or lock icon if restricted)
  - Active timer indicator (if timer running in channel)
  - Help button

- **Video Grid Area**
  - Responsive grid layout (auto-adjusts based on participant count)
  - Each participant tile shows:
    - Video feed (if video enabled)
    - Avatar with username overlay (if video disabled)
    - Speaking indicator (border glow when talking)
    - Muted icon (if participant is muted)
  - Grid shrinks tiles and reflows to keep all participants visible
  - Active speaker can be highlighted with subtle border

- **Bottom Control Bar** (always visible)
  - **Mute:** Toggle microphone on/off
  - **Deafen:** Toggle audio input/output off
  - **Video:** Toggle camera on/off
  - **Screen Share:** Share screen/window
  - **Chat:** Open chat overlay modal
  - **Leave:** Exit voice channel
  - Icons with labels below (Discord-style)

- **Chat Overlay Modal** (when chat button clicked)
  - Pops up from bottom control bar
  - Semi-transparent overlay over video tiles
  - Shows message history with achievement notifications (distinct styling)
  - Message input at bottom
  - Close button to dismiss overlay
  - Notification badge on chat icon shows unread count

**Study Tools in Voice Channel:**
- Right sidebar remains available (collapsed by default)
- When user starts timer, sharing prompt appears if in voice channel
- If user shares, other participants receive invite notification

**State Variations:**
- **Alone in Channel:** "You're the first one here. Waiting for others to join..."
- **Loading/Connecting:** "Connecting to voice channel..." with spinner
- **Connection Issues:** "Reconnecting..." overlay on affected user tiles
- **Screen Share Active:** Shared screen takes larger tile, others shrink to thumbnails

### 3.3 DM Page View

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ Direct Messages                             [+] Help   │
├───────────────────┬────────────────────────────────────┤
│                   │                                     │
│ 📌 Pinned DMs     │  [Selected DM Conversation View]   │
│ ───────────────   │                                     │
│ 🟢 Friend 1       │  Same as Text Channel View         │
│    Last msg...    │  (Message history + composer)      │
│                   │                                     │
│ Recent DMs        │                                     │
│ ───────────────   │                                     │
│ 🟢 Friend 2       │                                     │
│ 🔴 Friend 3       │                                     │
│ 🟡 Group Chat 1   │                                     │
│ ⚪ Friend 4       │                                     │
│                   │                                     │
└───────────────────┴────────────────────────────────────┘
```

**Component Hierarchy:**
- **Page Header**
  - Title: "Direct Messages"
  - [+] Button to start new DM (top-right)
  - Help button

- **DM List Panel (Left Side of Main Content)**
  - **Pinned Section:** DMs user has pinned (always at top)
  - **Recent Section:** DMs ordered by most recent message
  - Each DM list item shows:
    - User avatar (with online status indicator: green, red, yellow, gray)
    - Username or group chat name
    - Last message preview (truncated)
    - Timestamp
    - Unread indicator (badge count or bold styling)
  - Hover interaction: Shows preview modal with last 3 messages + most recent

- **DM Conversation View (Right Side)**
  - Identical to text channel message history and composer
  - Shows selected DM conversation
  - Message history scrollable
  - Message composer at bottom

- **New DM Modal** (when [+] clicked)
  - Search bar: "Search friends or server mutuals..."
  - Recommendations list:
    - Friends (top priority)
    - Server mutuals (below friends)
  - Multi-select support for group chats
  - [Create] button when recipients selected

**State Variations:**
- **No DMs Yet:** Empty state with 50% opacity message: "Start a conversation! Select a friend or use the + button to begin."
- **No Conversation Selected:** "Select a DM to view conversation"
- **Empty Conversation:** "This is the beginning of your conversation with [Username]"
- **Unread Messages:** Bold DM name, unread count badge
- **Hover Preview Modal:** Small overlay showing last 3 messages (not interactive)

### 3.4 Friends Page View

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ Friends                                     [?] Help   │
├────────────────────────────────────────────────────────┤
│ [All Friends] [Pending] [Blocked] [Add Friend]        │
├────────────────────────────────────────────────────────┤
│                                                         │
│ Search Friends: [________________]  [🔍]               │
│                                                         │
│ ┌────────────────────────────────────────────────────┐│
│ │ 🟢 Friend 1          Currently using: Pomodoro     ││
│ │    @username1        Timer                         ││
│ │    [Message] [Remove Friend]                       ││
│ └────────────────────────────────────────────────────┘│
│                                                         │
│ ┌────────────────────────────────────────────────────┐│
│ │ 🔴 Friend 2          Tags: Biology, Chemistry      ││
│ │    @username2                                       ││
│ │    [Message] [Remove Friend]                       ││
│ └────────────────────────────────────────────────────┘│
│                                                         │
└────────────────────────────────────────────────────────┘
```

**Component Hierarchy:**
- **Page Header:** "Friends" title, Help button
- **Tab Navigation:**
  - **All Friends:** Shows confirmed friends list
  - **Pending:** Shows sent/received friend requests
  - **Blocked:** Shows blocked users (future feature)
  - **Add Friend:** Opens add friend interface

- **Search Bar:** Search friends by exact username

- **Friends List:**
  - Each friend card shows:
    - Avatar with online status indicator
    - Username (display name)
    - @username (unique identifier)
    - Tags from their profile (if visible)
    - Current study tool status (if active and shared)
    - Action buttons: [Message] [Remove Friend]
  - Clicking anywhere on card (except buttons) opens user card modal

- **Add Friend Tab View:**
  - Search input: "Enter exact username"
  - Search button
  - Instructions: "Usernames are case-sensitive and must match exactly"
  - Search results appear below with [Send Request] button

- **Pending Tab View:**
  - **Incoming Requests:** Users who sent requests to you
    - Shows avatar, username
    - [Accept] [Deny] buttons
  - **Outgoing Requests:** Requests you've sent
    - Shows avatar, username, "Pending..." status
    - [Cancel Request] button

**State Variations:**
- **No Friends Yet:** "You haven't added any friends yet. Search for friends to get started!"
- **No Pending Requests:** "No pending friend requests"
- **Search No Results:** "User not found. Check spelling and try again."

### 3.5 Search/Discovery Page View

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ Discover Communities                        [?] Help   │
├────────────────────────────────────────────────────────┤
│ Search: [_____________________________]  [🔍]          │
│ Filters: [Category ▼] [Member Count ▼] [Tags ▼]       │
├────────────────────────────────────────────────────────┤
│                                                         │
│ Featured Communities                                    │
│ ─────────────────────                                  │
│ ┌─────────┐ ┌─────────┐ ┌─────────┐                  │
│ │ Banner  │ │ Banner  │ │ Banner  │                  │
│ │  [📖]   │ │  [🔬]   │ │  [💻]   │                  │
│ │Biology  │ │Chemistry│ │CS Study │                  │
│ │Study Hub│ │ Masters │ │ Group   │                  │
│ │#science │ │#science │ │#coding  │                  │
│ └─────────┘ └─────────┘ └─────────┘                  │
│                                                         │
│ Browse by Category                                      │
│ ─────────────────────                                  │
│ [🔬 Science] [💻 Technology] [📚 Humanities]          │
│ [🎨 Arts] [💼 Business] [🌍 Languages]                │
│                                                         │
└────────────────────────────────────────────────────────┘
```

**Component Hierarchy:**
- **Page Header:** "Discover Communities" title, Help button
- **Search Section:**
  - Search input bar (keyword search)
  - Filter dropdowns: Category, Member Count, Tags
  - Filters work without keyword entry

- **Initial/Empty State View:**
  - **Featured Communities:** Curated list of recommended communities
    - Card display: Banner image, logo icon, name, tags
    - Grid layout (3-4 per row)
  - **Category Tiles:** Large clickable tiles organized by subject
    - Each tile has icon and category name
    - Clicking filters results by that category

- **Search Results View:**
  - Same card layout as featured communities
  - Results update based on keyword + filters
  - "No results found" state if search yields nothing

- **Community Detail Modal** (when card clicked):
```
┌──────────────────────────────────────────────┐
│ [Large Banner Image]                     [×] │
│                                              │
│  [Logo]  Community Name                     │
│          @community-handle                   │
│                                              │
│  Description: Lorem ipsum dolor sit amet... │
│                                              │
│  📊 123 members  🏷️ #science #biology       │
│                                              │
│                              [Join]          │
└──────────────────────────────────────────────┘
```
  - Large banner at top
  - Logo, name, handle
  - Full description text
  - Member count, tags
  - [Join] button (for public communities)
  - [×] Close button

**State Variations:**
- **Initial State (No Search):** Featured communities + categories (this IS the default/"empty" state)
- **Search Results:** Filtered community cards based on criteria
- **No Results:** "No communities found matching your search. Try different keywords or filters."
- **Loading:** Skeleton loaders for community cards while fetching

### 3.6 Profile Page View

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ Profile                                     [?] Help   │
├────────────────────────────────────────────────────────┤
│                                                         │
│ [═══════════════ BANNER IMAGE ════════════════]       │
│                                                         │
│      [Avatar]                                          │
│      Username                            [Edit Profile]│
│      @uniquehandle                                      │
│                                                         │
│      Bio: This is my bio text...                       │
│                                                         │
│      🏷️ Tags: #Biology #Chemistry #PreMed             │
│                                                         │
│ ─────────────────────────────────────────────────────  │
│                                                         │
│ Study Stats (Optional, if shared):                     │
│ • Total study time: 45 hours this month                │
│ • Pomodoros completed: 87                              │
│ • Current streak: 12 days                              │
│                                                         │
│ Communities:                                            │
│ [Community 1] [Community 2] [Community 3]              │
│                                                         │
└────────────────────────────────────────────────────────┘
```

**Component Hierarchy:**
- **Page Header:** "Profile" title, Help button
- **Profile Display:**
  - Banner image (large, top of view)
  - Avatar (overlaps banner, centered or left-aligned)
  - Username (display name)
  - @uniquehandle (unique identifier)
  - Bio text (user-written description)
  - Tags (interests, subjects, verified organizations)
  - [Edit Profile] button (top-right, only on own profile)

- **Study Stats Section (Optional):**
  - Only shown if user opts to share study data
  - Metrics: Total study time, Pomodoros completed, streaks, etc.
  - Privacy: Private by default, user controls visibility

- **Communities Section:**
  - List/grid of communities user belongs to
  - Shows community icons/banners
  - Clickable to navigate to community

### 3.8 Community Settings Page (Admin/Owner)

**Access:** Click gear icon [⚙] next to community name in channel list

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ Community Settings                          [?] Help   │
├─────────────────┬──────────────────────────────────────┤
│                 │                                       │
│ Overview        │  [Community Settings Content]        │
│ Roles           │                                       │
│ Members         │  Based on selected sidebar option    │
│ Invites         │                                       │
│ Moderation      │                                       │
│ ───────────     │                                       │
│ Delete Community│                                       │
│                 │                                       │
└─────────────────┴──────────────────────────────────────┘
```

**Settings Sections (Discord-style):**

**Overview Tab:**
- Community name (editable)
- Community icon/logo (upload new)
- Community banner (upload new)
- Description (editable)
- Public/Private toggle
- Tags (add/remove)
- Default channels (cannot delete #general)
- Community region (for voice)

**Roles Tab:**
- List of roles: Owner, Admin, Moderator, Member
- Create new role button (post-MVP: custom roles)
- Edit role permissions
- Assign role color
- Set role hierarchy

**Members Tab:**
- List of all community members
- Search members
- Filter by role
- Click member → View profile, Assign role, Kick, Ban
- Bulk actions (select multiple)

**Invites Tab:**
- Generate new invite link
- Set expiration (24hrs, 7days, never)
- Set max uses (1, 10, 25, unlimited)
- List of active invites with stats (uses, creator, expires)
- Revoke invite links

**Moderation Tab:**
- Ban list (view, unban users)
- Audit log (view member actions, role changes, bans/kicks)
- Moderation settings
- Auto-moderation rules (post-MVP)

**Delete Community:**
- Red warning section at bottom
- Requires typing community name to confirm
- Permanent action, cannot be undone

### 3.9 Personal Settings Page

**Access:** Click "Settings" in top left navbar

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ User Settings                               [?] Help   │
├─────────────────┬──────────────────────────────────────┤
│                 │                                       │
│ My Account      │  [Settings Content]                  │
│ Profile         │                                       │
│ Privacy & Safety│  Based on selected sidebar option    │
│ Notifications   │                                       │
│ Appearance      │                                       │
│ Voice & Video   │                                       │
│ Keybinds        │                                       │
│ ───────────     │                                       │
│ Log Out         │                                       │
│                 │                                       │
└─────────────────┴──────────────────────────────────────┘
```

**Settings Sections (Discord-style):**

**My Account:**
- Username (editable)
- Email (editable)
- Password (change password)
- Two-factor authentication (enable/disable)
- Account deletion (red warning section)

**Profile:**
- Avatar upload
- Banner upload
- Bio (text editor with character limit)
- Tags (add/remove interests)
- @username (unique handle, editable with restrictions)

**Privacy & Safety:**
- Who can send you friend requests (Everyone, Friends of Friends, No One)
- Who can send you DMs (Everyone, Friends Only, No One)
- Allow DM requests from server members (toggle)
- Study time sharing (Private, Friends Only, Public)
- Blocked users list

**Notifications:**
- Enable desktop notifications (toggle)
- Enable sounds (toggle)
- Notification types to receive:
  - DMs (always on)
  - @Mentions
  - Friend requests
  - Accountability cards
  - Timer invites
  - Community invites
- Per-community notification overrides
- Quiet hours (set time range for muted notifications)

**Appearance:**
- Theme: Light, Dark, Auto (follow system)
- Message display: Cozy, Compact
- Font size slider
- Zoom level
- Color customization (post-MVP)

**Voice & Video:**
- Input device (microphone) selection
- Output device (speakers/headphones) selection
- Input/output volume sliders
- Test microphone button
- Camera selection
- Camera preview
- Video quality settings (Auto, 720p, 1080p)
- Screen share quality (Auto, High, Low)
- Echo cancellation (toggle)
- Noise suppression (toggle)
- Automatic gain control (toggle)

**Keybinds:**
- List of keyboard shortcuts
- Customize shortcuts (post-MVP)
- Reset to defaults

### 3.10 Study Tools Sidebar - Expanded View

**Collapsed State:**
```
│ S │
│ t │
│ u │
│ d │
│ y │
```
- Vertical text or icon only
- Slim width (~24-32px)
- Expand arrow/icon at top

**Expanded State:**
```
┌──────────────────────┐
│ Study Tools      [<] │
├──────────────────────┤
│                      │
│ 🍅 Pomodoro Timer    │
│ ─────────────────    │
│ Stay focused with    │
│ timed work sessions  │
│ and breaks.          │
│                      │
│ [Start Timer]        │
│                      │
├──────────────────────┤
│ 📅 Reminders         │
│ ─────────────────    │
│ Set personal         │
│ reminders for tasks  │
│ and deadlines.       │
│                      │
│ [Create Reminder]    │
│                      │
├──────────────────────┤
│ 📊 Study Stats       │
│ (Optional share)     │
│                      │
│ Today: 2h 15m        │
│ This week: 12h 30m   │
│ Pomodoros: 24        │
│                      │
└──────────────────────┘
```

**Component Breakdown:**
- **Header:** "Study Tools" title with collapse button [<]
- **Tool Cards:** Each tool has:
  - Icon and name
  - Brief description (2-3 lines)
  - Action button to launch
- **Personal Stats:** Optional section at bottom showing user's study data (if they've opted to track)

**Tool Cards (MVP):**
1. **Pomodoro Timer:** Launches timer modal when clicked
2. **Reminders:** Opens reminder creation form

**Admin-Only Tools (visible when in community with Admin+ role):**
3. **Accountability Cards:** Create card form (only visible in text channels)

**Post-MVP Tools:**
- Flashcards
- Active Recall
- Mind Maps
- Feynman Technique templates

### 3.11 Message Search Functionality

**Access:** 
- Search icon/bar in channel header (top-right of text channel view)
- Keyboard shortcut: Ctrl/Cmd + F

**Search Interface (Discord-style):**
```
┌────────────────────────────────────────────────────────┐
│ Search: [___________________________] [×]              │
├────────────────────────────────────────────────────────┤
│ Filters: [From: User ▼] [Has: Link ▼] [Date ▼]       │
├────────────────────────────────────────────────────────┤
│                                                         │
│ Search Results (23 messages)                           │
│ ─────────────────────────────────                      │
│                                                         │
│ User1 in #general - 2 days ago                         │
│ ...keyword highlighted in context...                   │
│ [Jump to Message]                                      │
│                                                         │
│ User2 in #study-group - 5 days ago                     │
│ ...keyword highlighted in context...                   │
│ [Jump to Message]                                      │
│                                                         │
└────────────────────────────────────────────────────────┘
```

**Search Features:**
- Search within current channel OR across entire community (toggle)
- Filters:
  - From specific user
  - Has: Links, Files, Images, Videos
  - Date range
  - In specific channel
- Results show message preview with keyword highlighted
- Click result → Jumps to message in channel (highlighted temporarily)
- Results paginated if many matches

### 3.12 Pinned Messages

**Pinning (Admin/Moderator only):**
- Right-click message → Pin Message
- Confirmation: "Pin this message? Pinned messages are visible to everyone."
- Maximum 50 pinned messages per channel

**Viewing Pinned Messages:**
- 📌 Pin icon appears in channel header when pins exist
- Click pin icon → Opens pinned messages panel (right sidebar overlay or modal)
- Shows all pinned messages in chronological order
- Each pinned message shows: Author, content, timestamp, "Jump to Message" button
- Admin+ can unpin messages from this panel

### 3.13 Reminder Creation Interface

**Access:** Study Tools sidebar → [Create Reminder]

**Reminder Form Modal:**
```
┌──────────────────────────────────────────────┐
│ Create Reminder                          [×] │
├──────────────────────────────────────────────┤
│                                              │
│ Title: [_______________________________]    │
│                                              │
│ Description (optional):                      │
│ [________________________________________]  │
│ [________________________________________]  │
│                                              │
│ Date: [MM/DD/YYYY]  Time: [HH:MM AM/PM]    │
│                                              │
│ Repeat: [None ▼]                            │
│         Options: None, Daily, Weekly,        │
│                  Monthly                     │
│                                              │
│                        [Cancel] [Create]     │
└──────────────────────────────────────────────┘
```

**Reminder Display:**
- Reminders appear as notification toasts at scheduled time
- Reminder list accessible in Study Tools sidebar (collapsed section)
- Can edit or delete reminders
- Mark as complete to dismiss

**Reminder Types:**
- Personal only (MVP)
- Shared accountability reminders = Accountability Cards (different feature)

### 3.14 File Upload Specifications

**File Size Limits:**
- Images: 8MB max
- Videos: 50MB max (or 2 minutes length)
- Audio: 25MB max
- Documents/Other files: 25MB max
- Total storage per community: Tiered (start with reasonable limit, expand post-MVP)

**Supported File Types:**
- **Images:** JPEG, PNG, GIF, WebP, SVG
- **Videos:** MP4, MOV, WebM
- **Audio:** MP3, WAV, OGG
- **Documents:** PDF, TXT, MD, DOCX, XLSX, PPTX
- **Code:** JS, PY, HTML, CSS, JSON, etc. (displayed with syntax highlighting)
- **Archives:** ZIP, RAR (download only, no preview)

**Upload Interface:**
- Drag & drop into message composer
- Click paperclip/attach icon → File picker
- Paste images directly into composer (Ctrl/Cmd + V)
- Multiple files at once (up to 10 files per message)

**Upload Progress:**
- Progress bar shown for each file
- Can cancel upload mid-progress
- Error handling for rejected files (size/type)

**File Display in Messages:**
- **Images:** Inline preview (click to expand fullscreen)
- **Videos:** Inline player with controls
- **Audio:** Inline player with waveform
- **Documents:** Card with icon, filename, size, [Download] button
- **Code files:** Syntax-highlighted preview (collapsible)

**Layout Structure:**
```
┌────────────────────────────────────────────────────────┐
│ Welcome to [Community Name]             [?] Help       │
├────────────────────────────────────────────────────────┤
│                                                         │
│ [═══════════════ BANNER IMAGE ════════════════]       │
│                                                         │
│                                                         │
│  Welcome to [Community Name]!                          │
│                                                         │
│  Before you can access channels, please review and     │
│  accept our community rules:                           │
│                                                         │
│  ┌──────────────────────────────────────────────────┐ │
│  │                                                  │ │
│  │  [Community Rules - Scrollable Text Area]       │ │
│  │                                                  │ │
│  │  1. Be respectful to all members...             │ │
│  │  2. No spam or self-promotion...                │ │
│  │  3. Stay on topic in designated channels...     │ │
│  │  ...                                             │ │
│  │                                                  │ │
│  └──────────────────────────────────────────────────┘ │
│                                                         │
│                              [I Accept the Rules]      │
│                                                         │
└────────────────────────────────────────────────────────┘
```

**Component Hierarchy:**
- **Header:** "Welcome to [Community Name]"
- **Banner:** Community banner image (optional)
- **Welcome Message:** Introductory text
- **Rules Section:**
  - Scrollable text area with community rules
  - Fully customizable by community owner
  - Can be formatted with markdown
  - Acts as Terms & Conditions gate
- **Accept Button:** [I Accept the Rules]
  - No decline option
  - Required to proceed into community
  - User cannot access channels until accepted

**State Variations:**
- **First Join:** Rules always shown
- **Rejoin (after leaving):** Rules may be shown again (community owner setting)

---

## 4. Interaction Patterns

### 4.1 Notification System

**Notification Types:**
- New DM messages
- @mentions in text channels
- Friend requests (sent/received)
- Accountability card invitations
- Timer invitations (to join group timer)
- DM requests from server mutuals
- Community invites

**Notification Display Location:**
- **Primary:** Top-right corner of main content area
  - If no timer active: Notifications appear here
  - If timer active: Notifications appear below timer modal
- **Style:** Small toast/card notifications
  - Auto-dismiss after few seconds OR
  - Clickable to navigate to source (e.g., click DM notification → opens DM)
  - Stack vertically if multiple notifications

**Notification Center (Future):**
- Bell icon in top navbar for notification history
- Badge count showing unread notifications
- MVP: Notifications are real-time toasts only

### 4.2 Unread Message Indicators

**Text Channels:**
- **Visual Break:** Horizontal line with "NEW MESSAGES" label appears above first unread message
- **Channel List:** Unread channels show bold text OR dot indicator next to name
- **@Mentions:** Special highlighting (different color/style from regular unreads)
  - Example: Red badge with count for mentions vs. white dot for regular unreads

**DMs:**
- **DM List:** Unread DMs show dot indicator next to avatar
- **DM Conversation:** Same "NEW MESSAGES" line break as text channels
- **Badge Count:** Number indicator on DM navigation button in top navbar (if unreads exist)

**Mark as Read Behavior:**
- Triggered on **focus** of channel/DM
- User opens channel/DM → Unread indicator clears
- Does not require scrolling to bottom or reading messages

### 4.3 Input & Control Behaviors

**Message Composer:**
- **Auto-expand:** Text area grows as user types (multi-line)
- **Keyboard Shortcuts:**
  - Enter: Send message (default)
  - Shift+Enter: New line without sending
  - Ctrl/Cmd+B: Bold
  - Ctrl/Cmd+I: Italic
  - Ctrl/Cmd+K: Insert link
- **Formatting Toolbar:** Click buttons to apply formatting at cursor position
- **Markdown Mode:** Toggle to see raw markdown vs. preview
- **File Attachment:** 
  - Drag & drop: Files dragged into composer area attach automatically
  - Click attach button: Opens file picker

**Voice Channel Controls:**
- **Mute:** Click to toggle mic on/off, visual feedback (red icon when muted)
- **Deafen:** Click to toggle all audio off (can't hear or be heard)
- **Video:** Click to toggle camera on/off
- **Screen Share:** Click to select screen/window to share, click again to stop
- **Chat:** Click to open chat overlay, badge shows unread count
- **Leave:** Click to exit voice channel, confirmation modal if timer is active

**Timer Controls:**
- **Start:** Single click in Study Tools sidebar
- **Stop:** Click [■] button in timer modal
  - Shows confirmation: "End timer now? This will notify linked participants."
- **No pause/resume:** Timer runs continuously until stopped or completed
- **Cannot minimize:** Timer modal always visible while active

### 4.4 Hover & Focus States

**Channel List Items:**
- **Hover:** Background color change, shows channel options icon (for Admin+)
- **Active:** Highlighted background, bold text for currently viewed channel

**Messages:**
- **Hover:** 3-dot menu appears on right side of message
- **Selected (for reply):** Subtle border/highlight to show which message being replied to

**User Avatars/Names:**
- **Hover:** Cursor changes to pointer, subtle highlight
- **Click:** Opens user card modal

**Community Cards (Search):**
- **Hover:** Scale slightly, shadow effect, "View Details" text appears
- **Click:** Opens community detail modal

**DM List Items:**
- **Hover:** Background color change, shows preview modal (last 3 messages)
- **Active:** Highlighted background for currently open DM

**Buttons:**
- **Hover:** Color change, subtle scale/shadow effect
- **Active (pressed):** Slight depression effect
- **Disabled:** Grayed out, no hover effects, cursor: not-allowed

### 4.5 Modal Interactions

**Full-Screen Timer Completion Modal:**
- **Appearance:** Blurs entire screen background, modal center-screen
- **Blocking:** User cannot interact with anything else until acknowledged
- **Actions:** [Continue to Next Session] or [End Timer]
- **Cannot dismiss:** No X button, no click-outside-to-close
- **Keyboard:** Enter key = Continue, Escape key = End (optional)

**Community Detail Modal (Search):**
- **Appearance:** Center-screen overlay with backdrop
- **Dismissal:** Click [×], click outside modal, or press Escape
- **Scrollable:** Content scrolls if description is long

**User Card Modal:**
- **Appearance:** Center-screen overlay, compact size
- **Content:** Banner, avatar, bio, tags, study status, action buttons
- **Dismissal:** Click outside, [×] button, or Escape key
- **Actions:** Add Friend, Send Message (if already friends)

**Warning Modals (Timer Conflict):**
- **Appearance:** Center-screen, medium size
- **Message:** Clear warning text about consequences
- **Actions:** [Yes, Continue] [No, Cancel]
- **Cannot dismiss:** Must choose an option

**Accountability Card Creation Form:**
- **Appearance:** Center-screen overlay, form layout
- **Fields:** Title, Description, Deadline, etc.
- **Actions:** [Create] [Cancel]
- **Validation:** Required fields marked, shows errors if incomplete

### 4.6 Drag & Drop Interactions

**File Upload:**
- User drags file over message composer
- Drop zone highlights (border/background change)
- Drop file → Attaches to message, preview shows
- Can drag multiple files at once

**Channel Reordering (Admin+):**
- Future feature: Drag channels to reorder in list
- Visual feedback: Channel lifts slightly, drop indicator line shows position

### 4.7 Context Menu Interactions

**Message Right-Click Menu:**
- Options shown based on permissions:
  - All users: Copy Message, Reply, Add Reaction
  - Message author: Edit, Delete
  - Moderator+: Delete Message, View Message Log
- Menu appears at cursor position
- Dismisses on click outside or selection

**User Right-Click Menu (in channel):**
- Options for Moderator+:
  - View Profile
  - View Message Log
  - Kick from Community
  - Ban from Community
- Regular users: View Profile only
- Menu appears at cursor position

**Channel Right-Click Menu (Admin+):**
- Edit Channel
- Delete Channel
- Manage Permissions
- Copy Channel Link
- Menu appears at cursor position

### 4.8 Keyboard Navigation

**General Navigation:**
- Tab: Move between focusable elements
- Shift+Tab: Reverse tab order
- Escape: Close modals, cancel actions
- Ctrl/Cmd+K: Quick search (future feature)

**Text Input:**
- Arrow keys: Navigate within text
- Ctrl/Cmd+A: Select all text
- Ctrl/Cmd+Z: Undo
- Ctrl/Cmd+Y: Redo

**Channel Navigation:**
- Alt+Up/Down: Switch between channels
- Alt+Shift+Up/Down: Switch between communities (future)
- Ctrl/Cmd+/: Show keyboard shortcuts help (future)

---

## 5. Design System Integration

### 5.1 Color System

**Primary Colors:**
- **Brand Primary:** Used for key actions, selected states, brand identity
- **Brand Secondary:** Used for accents, hover states

**Semantic Colors:**
- **Success/Green:** Confirmations, online status, active timers (work period)
- **Warning/Yellow:** Away status, cautions
- **Error/Red:** Errors, delete actions, offline status, timer stop button
- **Info/Blue:** Information, links, mentions

**Neutral Colors:**
- **Background Layers:** Multiple shades for depth (app bg, panel bg, card bg)
- **Text Colors:** Primary text, secondary text, disabled text
- **Border Colors:** Subtle borders for divisions

**Timer Colors:**
- **Work Period:** One distinct color (e.g., soft blue or green)
- **Break Period:** Different color (e.g., warm orange or purple)
- Clear visual distinction between states

### 5.2 Typography

**Font Hierarchy:**
- **Page Titles:** Large, bold (e.g., 24-32px)
- **Section Headers:** Medium, semi-bold (e.g., 18-20px)
- **Body Text:** Regular weight (e.g., 14-16px)
- **Small Text:** Timestamps, metadata (e.g., 12-14px)
- **Code/Monospace:** For code blocks and technical content

**Font Weights:**
- Regular (400): Body text
- Medium (500): Subheadings
- Semi-bold (600): Headings
- Bold (700): Emphasis, selected items

### 5.3 Spacing & Layout Grid

**Base Unit:** 4px or 8px system
- **Micro:** 4px (tight spacing within components)
- **Small:** 8px (component internal padding)
- **Medium:** 16px (spacing between related elements)
- **Large:** 24px (spacing between sections)
- **XL:** 32px+ (major section breaks)

**Component Padding:**
- Buttons: 8px vertical, 16px horizontal (medium size)
- Cards: 16-24px all sides
- Modals: 24-32px all sides
- Message bubbles: 8px vertical, 12px horizontal

**Grid System:**
- **Left Sidebar (Community List):** Fixed width (~72px for icons)
- **Middle Sidebar (Channel List):** Fixed width (~240px)
- **Main Content Area:** Fluid (grows with available space)
- **Right Sidebar (Study Tools):** Fixed width when expanded (~280-320px)

### 5.4 Component Patterns

**Buttons:**
- **Primary:** Solid background, high contrast (major actions like Join, Send, Accept)
- **Secondary:** Outline or subtle background (cancel, secondary actions)
- **Destructive:** Red/error color (delete, remove, ban)
- **Ghost:** Transparent, minimal (icon buttons, tertiary actions)
- **Sizes:** Small, Medium, Large
- **States:** Default, Hover, Active, Disabled, Loading

**Cards:**
- Rounded corners (4-8px border radius)
- Subtle shadow for elevation
- Hover state: Lift effect (increased shadow)
- Types: Community cards, DM cards, accountability cards

**Input Fields:**
- Border: Subtle outline in default state
- Focus: Border color changes, subtle glow/shadow
- Error: Red border, error message below
- Disabled: Grayed out, no interaction

**Badges & Indicators:**
- Unread counts: Small circular badge with number
- Status dots: Small circles next to avatars (online, offline, away)
- Channel indicators: Icons showing channel type, restrictions

**Dividers:**
- Horizontal lines: Separate sections (1px solid, subtle color)
- "NEW MESSAGES" divider: Bolder, colored, with text label

### 5.5 Icons & Imagery

**Icon System:**
- Consistent style (outline vs. solid)
- Sizes: 16px, 20px, 24px (based on context)
- Channel icons: # for text, speaker for voice, lock for restricted
- Action icons: Mute, video, share, settings, etc.
- Status icons: Online dot, timer indicator, notification bell

**Avatars:**
- Circular shape
- Sizes: Small (24px), Medium (40px), Large (80px), Profile (120px+)
- Fallback: Initials on colored background if no image

**Banners:**
- Aspect ratio: 16:9 or similar wide format
- Used in: Community cards, profile pages, community headers
- Fallback: Gradient or solid color if no image uploaded

### 5.6 Animation & Transitions

**Micro-interactions:**
- Button hover: 150ms ease transition (color, scale)
- Modal open/close: 200ms ease fade + scale
- Notification toast: Slide in from right, 300ms ease
- Message send: Subtle fade in, 150ms
- Unread indicator: Pulse animation (subtle, not distracting)

**Loading States:**
- Skeleton loaders for message history, community cards
- Spinner for actions (sending message, joining community)
- Progress bar for file uploads

**Page Transitions:**
- Smooth fade between views: 200ms ease
- No jarring cuts or flashes
- Maintain scroll position when navigating back

---

## 6. Accessibility Considerations

### 6.1 Keyboard Navigation

**Focus Indicators:**
- Clear visual outline on focused elements (2px solid, high contrast)
- Focus order follows logical reading flow (left to right, top to bottom)
- Skip links: "Skip to main content" for quick navigation

**Keyboard Shortcuts:**
- Essential actions accessible via keyboard
- Shortcuts documented in help section
- Avoid conflicts with browser/OS shortcuts

**Focus Management:**
- When modal opens, focus moves to modal
- When modal closes, focus returns to trigger element
- Tab traps within modals (can't tab outside)

### 6.2 Screen Reader Support

**Semantic HTML:**
- Proper heading hierarchy (h1 → h2 → h3)
- Landmark regions: header, nav, main, aside, footer
- Lists for navigation menus, channel lists

**ARIA Labels:**
- Buttons: Descriptive labels (not just icons)
- Form inputs: Associated labels
- Status messages: Use aria-live for dynamic content (notifications, timer updates)
- Modal: aria-modal="true", aria-labelledby for title

**Alt Text:**
- Images: Descriptive alt text
- Avatars: "Username's avatar"
- Decorative images: Empty alt="" to skip

**Live Regions:**
- Timer countdown: aria-live="polite" for updates
- Notifications: aria-live="assertive" for important alerts
- Message arrivals: Announced for screen readers

### 6.3 Visual Accessibility

**Color Contrast:**
- Text meets WCAG AA standards (4.5:1 for normal text, 3:1 for large text)
- Interactive elements: Clear contrast against background
- Don't rely on color alone: Use icons, text, patterns in addition

**Text Sizing:**
- Minimum 14px for body text
- Supports browser zoom up to 200%
- Relative units (rem/em) for scalability

**Touch Targets:**
- Minimum 44x44px for interactive elements
- Adequate spacing between clickable items
- Works well with touch input on tablets

**Motion & Animation:**
- Respect prefers-reduced-motion setting
- Disable non-essential animations for users who prefer reduced motion
- Provide alternative visual feedback without animation

### 6.4 Form Accessibility

**Labels & Instructions:**
- Every input has visible label
- Required fields marked with asterisk + text ("required")
- Error messages clear and specific
- Help text available for complex inputs

**Validation:**
- Inline validation on blur (as user leaves field)
- Error summary at top of form
- Errors announced to screen readers
- Focus moves to first error on submit attempt

### 6.5 Content Structure

**Readable Content:**
- Short paragraphs, clear language
- Headings break up long content
- Lists for scannable information

**Links:**
- Descriptive link text (not "click here")
- External links indicated
- Visited links have different color

---

## 7. Technical Implementation Notes

### 7.1 Frontend Architecture

**Technology Stack (Suggested):**
- **Framework:** React (component-based architecture)
- **State Management:** Context API + hooks (useState, useReducer) or Redux
- **Routing:** React Router for navigation
- **Styling:** Tailwind CSS or styled-components
- **Real-time:** WebSocket (Socket.io or native WebSocket API)
- **WebRTC:** For voice/video channels (PeerJS or native WebRTC)

**Component Structure:**
```
App
├── Layout
│   ├── TopNavbar (left section)
│   ├── TitleBar (center/right section)
│   ├── CommunityList (left sidebar)
│   ├── ChannelList (middle sidebar)
│   ├── MainContent (dynamic based on route)
│   └── StudyToolsSidebar (right sidebar)
├── Views
│   ├── TextChannelView
│   ├── VoiceChannelView
│   ├── DMView
│   ├── FriendsView
│   ├── SearchView
│   ├── ProfileView
│   └── SettingsView
├── Components
│   ├── Message
│   ├── MessageComposer
│   ├── AccountabilityCard
│   ├── TimerModal
│   ├── UserCard
│   ├── CommunityCard
│   └── NotificationToast
└── Modals
    ├── CommunityDetailModal
    ├── TimerCompletionModal
    ├── WarningModal
    └── AccountabilityFormModal
```

### 7.2 State Management Approach

**Global State:**
- User authentication & profile data
- Current community/channel selection
- Active timer state
- Notification queue
- WebSocket connection status

**Local Component State:**
- Form inputs
- UI toggles (sidebar collapsed/expanded)
- Hover states
- Modal open/close

**Server State (from API):**
- Communities list
- Channel lists
- Message history
- Friend list
- DM conversations
- User profiles

**Caching Strategy:**
- Cache frequently accessed data (communities, channels)
- Invalidate cache on updates
- Optimistic UI updates for better perceived performance

### 7.3 Real-Time Communication

**WebSocket Events:**
- **message.new:** New message in channel
- **message.delete:** Message deleted
- **message.edit:** Message edited
- **user.join:** User joined voice channel
- **user.leave:** User left voice channel
- **timer.start:** Timer started (shared)
- **timer.invite:** Invitation to join timer
- **timer.complete:** Timer reached completion
- **notification.new:** New notification for user
- **friend.request:** Friend request received
- **dm.new:** New DM received

**Connection Management:**
- Auto-reconnect on disconnect
- Show connection status indicator if disconnected
- Queue messages/actions while offline, send when reconnected

### 7.4 WebRTC Implementation

**Voice/Video Channels:**
- Peer-to-peer connections for efficient audio/video
- TURN/STUN servers for NAT traversal
- Automatic bitrate adjustment based on network conditions
- Echo cancellation and noise suppression

**Screen Sharing:**
- Use getDisplayMedia API
- Share entire screen or specific window
- Stop sharing button prominently displayed

**Audio Quality:**
- Opus codec for voice (low latency, good quality)
- Adaptive bitrate based on bandwidth
- Automatic gain control (AGC)

### 7.5 Performance Optimizations

**Code Splitting:**
- Lazy load routes (split bundles per view)
- Lazy load modals and heavy components
- Reduce initial bundle size

**Virtual Scrolling:**
- Use virtual list for long message history
- Only render visible messages + buffer
- Improves performance with thousands of messages

**Image Optimization:**
- Lazy load images as user scrolls
- Use responsive images (srcset)
- Compress uploaded images on backend
- Thumbnail generation for avatars and banners

**Debouncing & Throttling:**
- Search input: Debounce 300ms before API call
- Scroll events: Throttle for performance
- Window resize: Debounce layout recalculations

**Memoization:**
- Use React.memo for pure components
- useMemo for expensive calculations
- useCallback for stable function references

### 7.6 Error Handling

**Network Errors:**
- Retry logic for failed API calls (exponential backoff)
- Display user-friendly error messages
- Offline mode: Queue actions, sync when back online

**WebRTC Errors:**
- Permission denied: Clear instructions to enable mic/camera
- Connection failure: Fallback suggestions, check network
- Quality issues: Automatic quality reduction, user notification

**Form Validation Errors:**
- Client-side validation before submission
- Server-side validation as backup
- Clear error messages with resolution steps

**Graceful Degradation:**
- If WebRTC not supported: Show message, suggest browser update
- If WebSocket fails: Fall back to polling (less ideal but functional)
- If images fail to load: Show placeholder or fallback content

### 7.7 Security Considerations

**Authentication:**
- Secure token storage (httpOnly cookies or secure localStorage)
- Token refresh mechanism
- Session timeout for inactivity

**Input Sanitization:**
- Sanitize user input to prevent XSS attacks
- Markdown rendering: Use safe renderer (e.g., marked with sanitization)
- File uploads: Validate file types and sizes on backend

**WebSocket Security:**
- Authenticate WebSocket connections with tokens
- Validate all incoming messages
- Rate limiting to prevent spam/abuse

**Permissions Enforcement:**
- Check permissions on client AND server
- Hide UI elements user can't access
- Prevent unauthorized actions even if UI bypassed

---

## 8. Open Questions & Future Considerations

### 8.1 Unresolved Design Questions

**Timer Customization:**
- Post-MVP: Allow users to customize Pomodoro intervals?
- If yes, how does this affect shared timers? (Creator sets intervals for all?)

**User Status System:**
- Should we add Online/Away/DND/Offline statuses in future?
- Custom status messages ("Studying for finals")?
- Auto-away detection based on inactivity?

**Notification Preferences:**
- Granular control: Per-community notification settings?
- Quiet hours: Auto-mute during specified times?
- Notification sounds: Customizable or on/off only?

**Mobile Experience:**
- Responsive web vs. native mobile apps?
- Which features are mobile-priority?
- Touch gestures and mobile-specific interactions?

### 8.2 Scalability Considerations

**MVP Constraints:**
- 15 users per voice channel
- 100 users per community
- These are temporary limits for MVP

**Post-MVP Scaling:**
- Increase limits based on infrastructure capacity
- Optimize voice channel architecture for larger groups
- Community size: Unlimited or tiered based on subscription?

**Performance at Scale:**
- Message history: Pagination strategy for channels with thousands of messages
- Community list: How many communities can one user join before performance degrades?
- Search: Indexing and caching strategy for community discovery

### 8.3 Feature Expansion Ideas

**Study Tools Beyond MVP:**
- Active recall quizzes
- Flashcard creation and review
- Mind mapping tools
- Feynman Technique templates
- LaTeX support for math equations

**Social Features:**
- User achievements and badges
- Study streaks and leaderboards (opt-in)
- Study groups within communities (sub-communities?)
- Mentorship pairing system

**Integrations:**
- Canvas LMS: Assignment tracking, due dates, grades
- Google Classroom: Similar to Canvas
- Spotify: Shared listening, playlist recommendations
- Google Calendar: Sync study sessions and deadlines
- Notion/Trello: Task management integration

**Moderation Enhancements:**
- Automated content filtering (profanity, spam)
- AI-powered moderation suggestions
- Reporting system for users
- Appeal process for bans
- Audit logs for moderator actions

### 8.4 Analytics & Metrics

**User Analytics (Privacy-Conscious):**
- Study time tracking: Private by default, user controls sharing
- Pomodoro completion rates
- Community engagement metrics (for admins)
- Feature usage: Which tools are most popular?

**Platform Analytics:**
- DAU/MAU tracking
- User retention and churn rates
- Community health metrics (active members, message frequency)
- Voice channel utilization
- Peak usage times

**A/B Testing:**
- Test different UI patterns for key features
- Onboarding flow optimization
- Notification timing and frequency experiments

### 8.5 Monetization Strategy

**Potential Models:**
- **Freemium:** Free basic features, premium subscription for advanced tools
- **Institutional Licensing:** Schools pay for verified communities and enhanced features
- **Per-Community Tiers:** Free communities up to X members, paid for larger/premium features

**Premium Features (Ideas):**
- Larger community size limits
- Custom Pomodoro intervals
- Advanced study analytics
- Priority support
- Custom branding for communities
- More file storage per community

### 8.6 Compliance & Legal

**Data Privacy:**
- GDPR compliance (European users)
- COPPA compliance (users under 13)
- FERPA compliance (for LMS integrations with student data)
- Clear privacy policy and terms of service

**Content Moderation:**
- Community guidelines enforcement
- Legal liability for user-generated content
- DMCA takedown process for copyrighted content
- Age verification for certain communities?

**Accessibility Compliance:**
- WCAG 2.1 AA standard as baseline
- Regular accessibility audits
- User feedback mechanism for accessibility issues

---

## Appendix

### A. User Personas Recap

**Primary Persona: College Student (Sarah)**
- Age: 19-22
- Needs: Accountability, organization, collaborative study
- Pain Points: Juggling multiple apps, studying alone, lack of discipline
- Goals: Stay focused during study sessions, connect with classmates, track progress

**Secondary Persona: High School Student (Alex)**
- Age: 16-18
- Needs: Structured study for AP/SAT exams, peer support
- Pain Points: Distractions, procrastination, overwhelming workload
- Goals: Build consistent study habits, find study partners, improve grades

**Future Persona: Organization Admin (Prof. Johnson)**
- Role: Professor or tutor center coordinator
- Needs: Verified community for students, oversight tools, integration with LMS
- Goals: Create safe study environment, monitor engagement, support student success

### B. Competitive Analysis

**Discord:**
- Strengths: Robust community features, voice channels, familiar UI
- Weaknesses: Not study-focused, lacks accountability tools, can be distracting
- Study Room Differentiation: Integrated study tools, accountability features, purpose-built for students

**Slack:**
- Strengths: Professional communication, organized channels, search
- Weaknesses: Not designed for studying, expensive for large groups, overwhelming for students
- Study Room Differentiation: Student-friendly, free/