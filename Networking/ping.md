# Ping

```shell
ping localhost
```

## What happens when you run ping

1. Your machine (Mac) sends a small test message to a host — in this case localhost (which resolves to 127.0.0.1 — the IPv4 loopback address).
2. ping uses a protocol called ICMP (Internet Control Message Protocol), specifically the ICMP Echo Request and ICMP Echo Reply messages.
3. Your machine sends an Echo Request to the target IP.
4. If the target is reachable, it replies with an Echo Reply.
5. ping measures:
6. Round-trip time (RTT) — how long it takes for the request to go there and back.
7. Packet loss (if some pings don’t get replies).
8. It repeats this until you press Ctrl + C.


> PING localhost (127.0.0.1): 56 data bytes
64 bytes from 127.0.0.1: icmp_seq=0 ttl=64 time=0.060 ms


Let’s break it down:

1. PING localhost (127.0.0.1): 56 data bytes
2. → ping will send a 56-byte ICMP payload (the packet size excluding ICMP headers).
3. 64 bytes from 127.0.0.1
4. → The total size of the ICMP reply (56 bytes payload + 8 bytes ICMP header).
5. icmp_seq=0
6. → Sequence number of the ping (starts at 0, increments each request).
7. Useful to detect missing packets.
8. ttl=64
9. → Time To Live — a counter that prevents packets from looping forever.
10. Each router hop decrements it by 1.
11. 64 here means the packet didn’t leave your machine (localhost), so it’s unchanged.
12. time=0.060 ms
13. → Round-trip time in milliseconds (very small here since it’s local).


## What is a Packet?

A packet is the smallest chunk of data sent over a network.
It contains:
1. **Header** – Info about where it’s going (destination IP), where it’s from (source IP), protocol info, etc.
2. **Payload** – The actual data (in ping, this is the 56 bytes you see).
3. **Trailer** – Error checking bits (e.g., CRC).

## Ping and Packets

```shell
ping localhost
```

This happens:

1. Your computer sends an ICMP Echo Request packet to the target (localhost = 127.0.0.1).
- This packet has 64 bytes total:
- 8 bytes ICMP header
- 56 bytes payload (data)
2. The target (in this case, your own network stack) sends back an ICMP Echo Reply packet of the same size.


### Packet Loss in Ping

- If you send 10 ICMP request packets, you expect 10 ICMP reply packets back.
- If even 1 reply is missing (never received by your computer), that’s packet loss.

### It means:

- The packet was dropped somewhere in the network path.
- Or delayed so long it missed ping’s timeout window.
- Or blocked (e.g., firewall).


```text
PING 8.8.8.8 (8.8.8.8): 56 data bytes
64 bytes from 8.8.8.8: icmp_seq=0 ttl=117 time=12.5 ms
Request timeout for icmp_seq 1
64 bytes from 8.8.8.8: icmp_seq=2 ttl=117 time=13.1 ms
```

Here:
1. Sequence 1 never got a reply → 1 packet lost.
2. That’s packet loss.

