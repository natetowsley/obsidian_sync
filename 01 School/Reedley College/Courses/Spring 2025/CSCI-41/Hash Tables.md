---
Date Created: 2025-03-17T10:34
Favorite: false
tags: []
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
###### tags: #ComputerScience/DataStructuresAndAlgorithms #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#7.1]]
    - [[#Hash Tables]]
    - [[#Review Maps - General Concepts]]
        - [[#Common Map ADT Operations]]
        - [[#The map Class]]
        - [[#What is a Hash Table?]]
- [[#7.2]]
    - [[#Collisions & Searching]]
        - [[#End of Array]]
        - [[#Searching for a Key]]
- [[#7.3]]
    - [[#Deleting Records]]
        - [[#Issues with Hashing]]
- [[#7.4]]
    - [[#Methods of Resolution]]
        - [[#Collision Resolution by Chaining]]
        - [[#ChainingHashTableItem class]]
        - [[#Alternative Strategy: Closed Hashing]]
- [[#7.5]]
    - [[#Collision Resolution by Closed Hashing]]
    - [[#Closed Hashing I: Linear Probing]]
        - [[#Drawbacks of Linear Probing]]
        - [[#Load Factor in Linear Probing]]
    - [[#Closed Hashing II: Quadratic Probing]]
        - [[#Load Factor in Quadratic Probing]]
    - [[#Closed Hashing III: Double Hashing]]
        - [[#Load Factor in Double Hashing]]
    - [[#Summary]]
---
# 7.1
## Hash Tables
- The simplest kind of hash table is an array of records
    - This example has 701 records
![[image 38.png|image 38.png]]
## Review Maps - General Concepts
- A **map** is an associative container
- Each elemetn that is stored in a map has two parts: a **key** and a **value**
- To retrieve a specific value from a map, you use the key that is associated with that value
    - Similar to the process of looking up a word in the dictionary, where the words are keys and the definitions are values
- The map **insert** operation takes two parameter, a key and a value
    - If key does not exist in map, key-value pair is inserted
    - If key does exist, value is updated
- The map **get** operation takes one parameter for the key and returns the associated value, or null if the key does not exist in the map
- Ex: Employee IDs and names
![[image 1 23.png|image 1 23.png]]
### Common Map ADT Operations
![[image 2 21.png|image 2 21.png]]
### The `map` Class
- Standard Template Library has a map class that can be user to store key-value pairs
- The keys that are stored in a `map` container are unique - no duplicates
- The ==`map`== class is declared in the `<map>` header file
  
### What is a Hash Table?
- Each record has a speical field, called its **key**
- When a hash table is in use, some spots contain valid records, and other spots are “empty”
![[image 3 20.png|image 3 20.png]]
- In order to insert a new record, the **key** must somehow be **converted to** an array **index**
    - This process is called **hashing**
- The index is called the **hash value** of the key
- Typical way to create a hash value:
    - (Number mod 701)
- The hash value is used for the location of the new record
- **Hash Code:** A fixed-size, non-negative integer that attempts to uniquely identify a key
- A **hash function** is a function that computes a hash code for a given value
    - Hash functions are commonly specific to a data type\
**Hash Functions for string/ int**
```C++
int HashString(const string& value) { 
	int hashCode = 0;
	for (int character : value) {
		hashCode += character;
	}
	return (int) (hashCode & 0x7fffffff);
}
```
```C++
int HashInt (int value) {
	return (int) (value & 0x7fffffff);
}
```
  
# 7.2
## Collisions & Searching
- **Collisions** occur when a new record has a hash value of an already existing and valid record
    - When a collision occurs, move forward until you find an empty spot
    - The new record is inserted at that empty spot
### End of Array
- When there is a collision at the last index in the array, we circle back to index 0 to search for empty spots
### Searching for a Key
- The data that are attached to a key can be found fairly quickly
- Calculate the hash value based on the key
- Check that location of the array for the key
    - If the location has a different key than looking for, move forward until found or empty spot
- When the item is found, the data can be copied to the necessary location
- If the search reaches an empty spot, it can halt and return that the key could not be found in the table
  
# 7.3
## Deleting Records
- Records may also be deleted from a hash table
- The location must not be left as an ordinary “empty spot” since that could interfere with searches
- The location must be marked in some special way so that a search can tell that the spot used to have somthing in it
### Issues with Hashing
- Multiple keys can hash to the same slot = collisions are possible
    - Design hash functions such that collisions are minimized
    - But avoiding collisions is impossible
        - Design collision-resolution techniques
- Search will cost $O(n)$ time in the worst case
    - However, all operations can be made to have an expected complexity of $O(1)$
  
# 7.4
## Methods of Resolution
- Chaining
    - Store all elements that hash to the same slot in a linked list
    - Store a pointer to the head of the linked list in the hash table slot
- Open Addressing
    - All elements stored in hash table itself
    - When collisions occur, use a systematic (consistent) procedure to store elements in free slots of the table
![[image 4 18.png|image 4 18.png]]
Chaining example
![[image 5 18.png|image 5 18.png]]
Open Addressing example
### Collision Resolution by Chaining
![[image 6 15.png|image 6 15.png]]
- Search Cost
    - Unsuccessful search: Length of list (N)
    - Successful search: Half of list + 1 on average ((N/2) + 1)

> [!important] **Load Factor:** The number of items in the hash table divided by the number of buckets
- Optimal load factor
    - Zero! But between 1/2 and 1 is fast and makes good use of memory
### ChainingHashTableItem class
```C++
template <typename K, typename V>
class ChainingHashTableItem {
public:
	K key;
	V value;
	ChainingHashTableItem<K, V>* next;
	
	ChainingHashTableItem(constK& itemKey, const V& itemValue) : key (itemKey), value(itemValue) {
		next = nullptr;
	}
};
```
### Alternative Strategy: Closed Hashing
- Problem with separate chaining:
    - Memory consumed by pointers - 32 (or 64) bits per key
- What if we only allow one Key at each entry?
    - Two objects that hash to the same spot can’t both go there
    - First one there gets the spot
    - Next one must go in another spot
- Properties
    - N ≤ 1
    - Performance degrades with difficulty of finding right spot
![[image 7 13.png|image 7 13.png]]
  
# 7.5
## Collision Resolution by Closed Hashing
- Given an item X, try cells $h_0(X), h_1(X),h_2(X),...,h_i(X)$
- $h_i(X) = (Hash(X) + F(i))$ mod $TableSize$
    - Define F(0) = 0
- F is the _collision resolution_ function
    - Some possibilities:
        - **Linear:** F(i) = i
        - **Quadratic:** F(i) = $i^2$ (zyBooks: $c2 * i^2$)
        - **Double Hashing:** F(i) = $i⍰Hash_2(X)$
## Closed Hashing I: Linear Probing
- Main Idea: When collision occurs, scan down the array one cell at a time looking for an empty cell
    - $h_i(X) = (Hash(X) + i)mod TableSize$ (i = 0, 1, 2,…)
    - Compute hash value and increment it until a free cell is found
**Inserting with Linear Probing**
```C++
// Inserts the specified key/value pair. If the key already exists, the 
// corresponding value is updated. If inserted or updated, true is returned. 
// If not inserted, then false is returned.
bool Insert(const K& key, const V& value) {
   // Get the key's hash code
   int hashCode = Hash(key);
   // First search for the key in the table. If found, update bucket's value.
   for (int i = 0; i < table.size(); i++) {
      int bucketIndex = (hashCode + i) % table.size();
         
      // An empty-since-start bucket implies the key is not in the table
      if (table[bucketIndex]->IsEmptySinceStart()) {
         break;
      }
         
      if (!table[bucketIndex]->IsEmptyAfterRemoval()) {
         // Check if the non-empty bucket has the key
         if (key == *table[bucketIndex]->key) {
            // Update the value
            delete table[bucketIndex]->value;
            table[bucketIndex]->value = new V(value);
            return true;
         }
      }
   }
      
   // The key is not in the table, so insert into first empty bucket
   for (int i = 0; i < table.size(); i++) {
      int bucketIndex = (hashCode + i) % table.size();
      if (table[bucketIndex]->IsEmpty()) {
         table[bucketIndex] = new OpenAddressingBucket(key, value);
         return true;
      }
   }
      
   return false; // no empty bucket found
}
```
- EX:
![[image 8 11.png|image 8 11.png]]
### Drawbacks of Linear Probing
- Works until array is full, but as number of items N approaches TableSize, access time approaches O(N)
- Very prone to cluster formation (as in example)
    - If a key hashes anywhere into a cluster, finding a free cell involves going through the entire cluster - and making it grow
    - **Primary Clustering:** Clusters grow when kays hash to values close to each other
- Can have cases where table is empty except for a few clusters
    - Does not satisfy good hash function criterion of distributing keys uniformly
### Load Factor in Linear Probing
- For any N < 1, linear probing will find an empty slot
- Search cose (assuming simple uniform hashing)
    - Successful search: $1/2(1+(1/(1-N)))$
    - Unsuccessful search: $1/2(1+(1/(1-N)^2))$
- Performance quickly degrades for N > 1/2
**Optimal vs Linear**
![[image 9 10.png|image 9 10.png]]
## Closed Hashing II: Quadratic Probing
- Main Idea: Spread out the search for an empty slot - Increment by $i^2$ instead of $i$
**Inserting with Quadratic Probing**
```C++
// Inserts the specified key/value pair. If the key already exists, the 
// corresponding value is updated. If inserted or updated, true is returned. 
// If not inserted, then false is returned.
bool Insert(const K& key, const V& value) override {
   // Get the key's hash code
   int hashCode = Hash(key);
   // First search for the key in the table. If found, update bucket's value.
   for (int i = 0; i < table.size(); i++) {
      int bucketIndex = (hashCode + c1 * i + c2 * i * i) % table.size();
         
      // An empty-since-start bucket implies the key is not in the table
      if (table[bucketIndex]->IsEmptySinceStart()) {
         break;
      }
         
      if (!table[bucketIndex]->IsEmptyAfterRemoval()) {
         // Check if the non-empty bucket has the key
         if (key == *table[bucketIndex]->key) {
            // Update the value
            delete table[bucketIndex]->value;
            table[bucketIndex]->value = new V(value);
            return true;
         }
      }
   }
      
   // The key is not in the table, so insert into first empty bucket
   for (int i = 0; i < table.size(); i++) {
      int bucketIndex = (hashCode + c1 * i + c2 * i * i) % table.size();
      if (table[bucketIndex]->IsEmpty()) {
         table[bucketIndex] = new OpenAddressingBucket(key, value);
         return true;
      }
   }
      
   return false; // no empty bucket found
}
```
- $h_i(X) = (Hash(X) + i^2) \%TableSize$
    - $h_0(X) = Hash(X) \%TableSize$
    - $h_1(X) = Hash(X) + 1 \%TableSize$
    - $h_2(X) = Hash(X) + 4 \%TableSize$
    - $h_3(X) = Hash(X) + 9 \%TableSize$
- EX:
![[image 10 10.png|image 10 10.png]]
### Load Factor in Quadratic Probing
- Theorem: If TableSize is prime and N ≤ 1/2, queadratic probing will find an empty slot; for greater N, might not
- With load factors near 1/2, the expected number of probes is empirically near optimal - no exact analysis known
- Don’t get clustering from similar keys (primary clustering), still get clustering from identical keys (secondary clustering)
## Closed Hashing III: Double Hashing
- Idea: Spread out the search for an empty slot by using a second hash function
    - No primary or secondary clustering
- $h_1(X) = (Hash_1(X) + i⍰Hash_2(X))\%TableSize$ for i = 0, 1, 2,… etc.
- Good choice of Hash_2(X) can guarantee does not get “stuck” as long as N < 1
    - Integer keys:
        - $Hash_2(X) = R - (X\%R)$ where R is a prime smaller than TableSize
- EX:
![[image 11 10.png|image 11 10.png]]
### Load Factor in Double Hashing
- For any N < 1, double hashing will find an empty slot (given appropriate table size and $hash_2$)
- Search cost approaches optimal (random re-hash):
    - Successful search: $(1/N)ln(1/(1-N)$
    - Unsuccessful search: $1/(1-N)$
- No primary clustering or secondary clustering
- Still becomes costly as N nears 1
## Summary
- Hash tables store a collection of records with keys
- The location of a record depends on the hash value of the record’s key
- WHen a collision occurs, the next available location is used
- Searching for a particular key is generally quick
- When an item is deleted, the location must be marked in a special way, so that the searches know that the spot used to be used