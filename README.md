# Smart Notepad using JavaFX

A very simple yet algorithmically smart notepad. It's a PoC for real world application of the algorithms other than solving leetcode problems:)

## Working
### UI
1. uses OpenJFX for creating a User Interface for interacting with the internal data structures.

### Inner Implementation
1. Uses a weighted Trie (Prefix Tree) for storing a dictionary of word and then adjust the weights as the user starts generating feedback, either by accepting suggestions or by typing new words.

## Features
- simple UI
- Built-in autocomplete feature
- learning on the go as you type

## Planned
- Full Editor controls
- Integrate word replacement -> Alpha
- Persistent memory

## Improvements
- Implement Suggest Trees (Suffix Tree) in place of Prefix Tree for more efficient and Roubust autocomplete mechanism.
