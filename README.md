# Java List Implementations
## Two Implementations of Character List Data Structures

This project provides two implementations of a character list data structure in Java:
1. **ArrayList-based implementation** - using Java's ArrayList under the hood
2. **Circular linked list** - using nodes with circular references

Both implementations support the same set of operations while demonstrating different underlying data structures.

---
## Variant Information
### The last four digits of a student ID: 0370
**370 % 4 = 2**
---
## Features

### Common Operations Supported:
- `append(element)` - Add to end of list
- `insert(element, index)` - Insert at specific position
- `delete(index)` - Remove by index
- `deleteAll(element)` - Remove all occurrences
- `get(index)` - Access by index
- `clone()` - Create deep copy
- `reverse()` - Reverse list in-place
- `findFirst(element)`/`findLast(element)` - Search operations
- `clear()` - Empty the list
- `extend(otherList)` - Merge with another list

---
## Installation & Setup

### Prerequisites:
- Java JDK 17 or later
- Gradle

### Building and Testing:
```bash
# Clone the repository
git clone https://github.com/yourusername/mtprz-lab3
cd mtprz-lab3

# Build the project
./gradlew build

# Run tests
./gradlew test
```
---
## Failed CI commit:

https://github.com/watashone/mtprz-lab3/commit/a47ea44e82d492525bf23d58e5d9fd39eff4e26f

## Conclusions
Unit tests proved invaluable by catching subtle bugs in circular list behavior. They gave me confidence to refactor aggressively while maintaining correctness. Testing revealed design flaws early, saving debugging time later. The tests now serve as living documentation of expected behavior. For complex data structures like these, unit testing was absolutely worth the investment—it prevented far more problems than it cost in effort. The safety net allowed faster iteration without fear of breaking existing functionality. What seemed like extra work upfront paid off in long-term reliability.
