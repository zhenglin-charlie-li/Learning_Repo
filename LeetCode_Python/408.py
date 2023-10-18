class Solution:
    def validWordAbbreviation(self, word: str, addr: str) -> bool:
        word_ptr = addr_ptr = 0
        while word_ptr < len(word) and addr_ptr < len(addr):
            if addr[addr_ptr].isdigit():
                steps = 0
                while addr_ptr < len(addr) and addr[addr_ptr].isdigit():
                    steps = steps * 10 + int(addr[addr_ptr])
                    addr_ptr += 1
                word_ptr += steps
            else:
                if word[word_ptr] != addr[addr_ptr]:
                    return False
                else:
                    addr_ptr += 1
                    word_ptr += 1
        return word_ptr == len(word) and addr_ptr == len(addr)

# Time: O(n)
# Space: O(1)
