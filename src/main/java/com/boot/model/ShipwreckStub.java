package com.boot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipwreckStub {
	private static Map<Long, Shipwreck> wrecks = new HashMap<>(Map.of(1L, new Shipwreck(1L, "U869", "A very deep German UBoat", "FAIR", 200, 44.12, 138.44, 1994),
			2L, new Shipwreck(2L, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80, 44.12, 138.44, 1994),
			3L, new Shipwreck(3L, "S.S. Yongala", "A luxury passenger ship wrecked on the great barrier reef", "FAIR", 50, 44.12, 138.44, 1994)));

	private static Long idIndex = 3L;

	public static List<Shipwreck> list() {
		return new ArrayList<>(wrecks.values());
	}

	public static Shipwreck create(Shipwreck wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		wrecks.put(idIndex, wreck);
		return wreck;
	}

	public static Shipwreck get(Long id) {
		return wrecks.get(id);
	}

	public static Shipwreck update(Long id, Shipwreck wreck) {
		wrecks.put(id, wreck);
		return wreck;
	}

	public static Shipwreck delete(Long id) {
		return wrecks.remove(id);
	}
}
