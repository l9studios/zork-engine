package zork;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import zork.commands.ReadTest;
import zork.engine.EngineTest;

/**
 * http://steel.lcc.gatech.edu/~marleigh/zork/transcript.html
 */
public class ZorkOneTranscriptTest extends EngineTest {

	@Test
	public void transcript() {

		verify("open mailbox", "Opening the small mailbox reveals a leaflet.");

		verify("read leaflet", "(Taken)\n" + ReadTest.LEAFLET_DESCRIPTION);

		verify("drop leaflet", "Dropped.");

		verify("go south", "South of House\nYou are facing the south side of a white house. There is no door here, and all the windows are boarded.");

		verify("go east",
				"Behind House\nYou are behind the white house. A path leads into the forest to the east. In one corner of the house there is a small window which is slightly ajar.");

		verify("open window", "With great effort, you open the window far enough to allow entry.");

		verify("enter house",
				"Kitchen\n"
						+ "You are in the kitchen of the white house. A table seems to have been used recently for the preparation of food. A passage leads to the west and a dark staircase can be seen leading upward. A dark chimney leads down and to the east is a small window which is open. On the table is an elongated brown sack, smelling of hot peppers. A bottle is sitting on the table.\n"
						+ "The glass bottle contains:\n"
						+ "  A quantity of water");

		verify("go west",
				"Living Room\n"
						+ "You are in the living room. There is a doorway to the east, a wooden door with strange gothic lettering to the west, which appears to be nailed shut, a trophy case, and a large oriental rug in the center of the room. Above the trophy case hangs an elvish sword of great antiquity. A battery-powered brass lantern is on the trophy case.");

		verify("take lamp", "Taken.");

		verify("move rug", "With a great effort, the rug is moved to one side of the room, revealing the dusty cover of a closed trap door.");

		verify("open trap door", "The door reluctantly opens to reveal a rickety staircase descending into darkness.");

		verify("turn on lamp", "The brass lantern is now on.");

		verify("go down",
				"The trap door crashes shut, and you hear someone barring it.\n\nCellar\n"
						+ "You are in a dark and damp cellar with a narrow passageway leading north, and a crawlway to the south. On the west is the bottom of a steep metal ramp which is unclimbable.");

		verify("go south", "East of Chasm\n"
				+ "You are on the east edge of a chasm, the bottom of which cannot be seen. A narrow passage goes north, and the path you are on continues to the east.");

		verify("go east", "Gallery\n"
				+ "This is an art gallery. Most of the paintings have been stolen by vandals with exceptional taste. The vandals left through either the north or west exits.\n"
				+ "Fortunately, there is still one chance for you to be a vandal, for on the far wall is a painting of unparalleled beauty.");

		verify("take painting", "Taken.");

		verify("go north",
				"Studio\n"
						+ "This appears to have been an artist's studio. The walls and floors are splattered with paints of 69 different colors. Strangely enough, nothing of value is hanging here. At the south end of the room is an open door (also covered with paint). A dark and narrow chimney leads up from a fireplace; although you might be able to get up it, it seems unlikely you could get back down.\n"
						+ "Loosely attached to a wall is a small piece of paper.");

		verify("go up chimney", "Kitchen\n"
				+ "On the table is an elongated brown sack, smelling of hot peppers.\n"
				+ "A bottle is sitting on the table.\n"
				+ "The glass bottle contains:\n"
				+ "  A quantity of water");

		verify("go up", "Attic\n"
				+ "This is the attic. The only exit is a stairway leading down.\n"
				+ "A large coil of rope is lying in the corner.\n"
				+ "On a table is a nasty-looking knife.");

		verify("take knife", "Taken.");

		verify("take rope", "Taken.");

		verify("", "");
		verify("", "");
	}

	private void verify(String input, String output) {
		assertThat(engine.interact(input), is(output));
	}

}

// >go down
// Kitchen
// On the table is an elongated brown sack, smelling of hot peppers.
// A bottle is sitting on the table.
// The glass bottle contains:
// A quantity of water
//
// >go west
// Living Room
// Above the trophy case hangs an elvish sword of great antiquity.
//
// >open case
// Opened.
//
// >put painting inside case
// Done.
//
// >drop knife
// Dropped.
//
// >take sword
// Taken.
//
// >open trap door
// The door reluctantly opens to reveal a rickety staircase descending into
// darkness.
//
// >go down
// The trap door crashes shut, and you hear someone barring it.
//
// Cellar
// Your sword is glowing with a faint blue glow.
//
// >go north
// The Troll Room
// This is a small room with passages to the east and south and a forbidding
// hole leading west. Bloodstains and deep scratches (perhaps made by an axe)
// mar the walls.
// A nasty-looking troll, brandishing a bloody axe, blocks all passages out of
// the room.
// Your sword has begun to glow very brightly.
// The troll's mighty blow drops you to your knees.
//
// >kill troll with sword
// You are still recovering from that last blow, so your attack is ineffective.
// The troll's axe barely misses your ear.
//
// >kill troll with sword
// Clang! Crash! The troll parries.
// The troll's axe barely misses your ear.
//
// >kill troll with sword
// The troll is confused and can't fight back.
// The troll slowly regains his feet.
//
// >kill troll with sword
// The troll is knocked out!
//
// >kill troll with sword
// The unarmed troll cannot defend himself: He dies.
// Almost as soon as the troll breathes his last breath, a cloud of sinister
// black fog envelops him, and when the fog lifts, the carcass has disappeared.
// Your sword is no longer glowing.
//
// >drop sword
// Dropped.
//
// >go east
// East-West Passage
// This is a narrow east-west passageway. There is a narrow stairway leading
// down at the north end of the room.
//
// >go east
// Round Room
// This is a circular stone room with passages in all directions. Several of
// them have unfortunately been blocked by cave-ins.
//
// >go southeast
// Engravings Cave
// You have entered a low cave with passages leading northwest and east.
// There are old engravings on the walls here.
// >go east
// Dome Room
// You are at the periphery of a large dome, which forms the ceiling of another
// room below. Protecting you from a precipitous drop is a wooden railing which
// circles the dome.
//
// >tie rope to railing
// The rope drops over the side and comes within ten feet of the floor.
//
// >go down
// Torch Room
// This is a large room with a prominent doorway leading to a down staircase.
// Above you is a large dome. Up around the edge of the dome (20 feet up) is a
// wooden railing. In the center of the room sits a white marble pedestal.
// A piece of rope descends from the railing above, ending some five feet above
// your head.
// Sitting on the pedestal is a flaming torch, made of ivory.
//
// >go south
// Temple
// This is the north end of a large temple. On the east wall is an ancient
// inscription, probably a prayer in a long-forgotten language. Below the prayer
// is a staircase leading down. The west wall is solid granite. The exit to the
// north end of the room is through huge marble pillars.
// There is a brass bell here.
//
// >go east
// Egyptian Room
// This is a room which looks like an Egyptian tomb. There is an ascending
// staircase to the west.
// The solid-gold coffin used for the burial of Ramses II is here.
//
// >take coffin
// Taken.
//
// >go west
// Temple
// There is a brass bell here.
//
// >go south
// Altar
// This is the south end of a large temple. In front of you is what appears to
// be an altar. In one corner is a small hole in the floor which leads into
// darkness. You probably could not get back up it.
// On the two ends of the altar are burning candles.
// On the altar is a large black book, open to page 569.
//
// >pray
// Forest
// This is a forest, with trees in all directions. To the east, there appears to
// be sunlight.
//
// >turn off lamp
// The brass lantern is now off.
//
// >go south
// Forest
// This is a dimly lit forest, with large trees all around.
//
// >go north
// Clearing
// You are in a small clearing in a well marked forest path that extends to the
// east and west.
//
// >go east
// Canyon View
// You are at the top of the Great Canyon on its west wall. From here there is a
// marvelous view of the canyon and parts of the Frigid River upstream. Across
// the canyon, the walls of the White Cliffs join the mighty ramparts of the
// Flathead Mountains to the east. Following the Canyon upstream to the north,
// Aragain Falls may be seen, complete with rainbow. The mighty Frigid River
// flows out from a great dark cavern. To the west and south can be seen an
// immense forest, stretching for miles around. A path leads northwest. It is
// possible to climb down into the canyon from here.
//
// >go down
// Rocky Ledge
// You are on a ledge about halfway up the wall of the river canyon. You can see
// from here that the main flow from Aragain Falls twists along a passage which
// it is impossible for you to enter. Below you is the canyon bottom. Above you
// is more cliff, which appears climbable.
//
// >go down
// Canyon Bottom
// You are beneath the walls of the river canyon which may be climbable here.
// The lesser part of the runoff of Aragain Falls flows by below. To the north
// is a narrow path.
//
// >go north
// End of Rainbow
// You are on a small, rocky beach on the continuation of the Frigid River past
// the Falls. The beach is narrow due to the presence of the White Cliffs. The
// river canyon opens here and sunlight shines in from above. A rainbow crosses
// over the falls to the east and a narrow path continues to the southwest.
//
// >drop coffin
// Dropped.
//
// >open coffin
// The gold coffin opens.
// A sceptre, possibly that of ancient Egypt itself, is in the coffin. The
// sceptre is ornamented with colored enamel, and tapers to a sharp point.
//
// >take sceptre
// Taken.
//
// >wave sceptre
// Suddenly, the rainbow appears to become solid and, I venture, walkable (I
// think the giveaway was the stairs and bannister).
// A shimmering pot of gold appears at the end of the rainbow.
//
// >take gold
// Taken.
//
// >take coffin
// Taken.
//
// >go southwest
// Canyon Bottom
//
// >go up
// Rocky Ledge
//
// >go up
// Canyon View
//
// >go northwest
// Clearing
//
// >go west
// Behind House
//
// >enter house
// Kitchen
// On the table is an elongated brown sack, smelling of hot peppers.
// A bottle is sitting on the table.
// The glass bottle contains:
// A quantity of water
//
// >open bag
// Opening the brown sack reveals a lunch, and a clove of garlic.
//
// >take garlic
// Taken.
//
// >go west
// Living Room
// There is a nasty knife here.
// Your collection of treasures consists of:
// A painting
//
// >put coffin in case
// Done.
//
// >put gold in case
// Done.
//
// >put sceptre in case
// Done.
//
// >open trap door
// The door reluctantly opens to reveal a rickety staircase descending into
// darkness.
//
// >turn on lamp
// The brass lantern is now on.
//
// >go down
// Cellar
//
// >go north
// The Troll Room
// There is a sword here.
// There is a bloody axe here.
//
// >go east
// East-West Passage
//
// >go north
// Chasm
// A chasm runs southwest to northeast and the path follows it. You are on the
// south side of the chasm, where a crack opens into a passage.
//
// >go northeast
// Reservoir South
// You are in a long room on the south shore of a large lake, far too deep and
// wide for crossing.
// There is a path along the stream to the east or west, a steep pathway
// climbing southwest along the edge of a chasm, and a path leading into a
// canyon to the southeast.
//
// >go east
// Dam
// You are standing on the top of the Flood Control Dam #3, which was quite a
// tourist attraction in times far distant. There are paths to the north, south,
// and west, and a scramble down.
// The sluice gates on the dam are closed. Behind the dam, there can be seen a
// wide reservoir. Water is pouring over the top of the now abandoned dam.
// There is a control panel here, on which a large metal bolt is mounted.
// Directly above the bolt is a small green plastic bubble.
//
// >go north
// Dam Lobby
// This room appears to have been the waiting room for groups touring the dam.
// There are open doorways here to the north and east marked "Private", and
// there is a path leading south over the top of the dam.
// Some guidebooks entitled "Flood Control Dam #3" are on the reception desk.
// There is a matchbook whose cover says "Visit Beautiful FCD#3" here.
//
// >take matches
// Taken.
//
// >go north
// Maintenance Room
// This is what appears to have been the maintenance room for Flood Control Dam
// #3. Apparently, this room has been ransacked recently, for most of the
// valuable equipment is gone. On the wall in front of you is a group of buttons
// colored blue, yellow, brown, and red. There are doorways to the west and
// south.
// There is a group of tool chests here.
// There is a wrench here.
// There is an object which looks like a tube of toothpaste here.
// There is a screwdriver here.
//
// >take wrench
// Taken.
//
// >take screwdriver
// Taken.
//
// >push yellow button
// Click.
//
// >go south
// Dam Lobby
// Some guidebooks entitled "Flood Control Dam #3" are on the reception desk.
//
// >go south
// Dam
// You are standing on the top of the Flood Control Dam #3, which was quite a
// tourist attraction in times far distant. There are paths to the north, south,
// and west, and a scramble down.
// The sluice gates on the dam are closed. Behind the dam, there can be seen a
// wide reservoir. Water is pouring over the top of the now abandoned dam.
// There is a control panel here, on which a large metal bolt is mounted.
// Directly above the bolt is a small green plastic bubble which is glowing
// serenely.
//
// >turn bolt with wrench
// The sluice gates open and water pours through the dam.
//
// >drop wrench
// Dropped.
//
// >go south
// Deep Canyon
// You are on the south edge of a deep canyon. Passages lead off to the east,
// northwest and southwest. A stairway leads down. You can hear a loud roaring
// sound, like that of rushing water, from below.
//
// >go down
// Loud Room
// This is a large room with a ceiling which cannot be detected from the ground.
// There is a narrow passage from east to west and a stone stairway leading
// upward. The room is deafeningly loud with an undetermined rushing sound. The
// sound seems to reverberate from all of the walls, making it difficult even to
// think.
// On the ground is a large platinum bar.
// It is unbearably loud here, with an ear-splitting roar seeming to come from
// all around you. There is a pounding in your head which won't stop. With a
// tremendous effort, you scramble out of the room.
//
// Round Room
//
// >go southeast
// Engravings Cave
// There are old engravings on the walls here.
//
// >go east
// Dome Room
//
// >go down
// Torch Room
// Sitting on the pedestal is a flaming torch, made of ivory.
//
// >take torch
// Taken.
//
// >turn off lamp
// The brass lantern is now off.
//
// >go south
// Temple
// There is a brass bell here.
//
// >take bell
// Taken.
//
// >go south
// Altar
// On the two ends of the altar are burning candles.
// On the altar is a large black book, open to page 569.
//
// >take candles
// Taken.
//
// >take book
// Taken.
//
// >go down
// Cave
// This is a tiny cave with entrances west and north, and a dark, forbidding
// staircase leading down.
//
// >go down
// Entrance to Hades
// You are outside a large gateway, on which is inscribed
//
// Abandon every hope all ye who enter here!
//
// The gate is open; through it you can see a desolation, with a pile of mangled
// bodies in one corner. Thousands of voices, lamenting some hideous fate, can
// be heard.
// The way through the gate is barred by evil spirits, who jeer at your attempts
// to pass.
//
// >ring bell
// The bell suddenly becomes red hot and falls to the ground. The wraiths, as if
// paralyzed, stop their jeering and slowly turn to face you. On their ashen
// faces, the expression of a long-forgotten terror takes shape.
// In your confusion, the candles drop to the ground (and they are out).
//
// >take candles
// Taken.
//
// >light match
// One of the matches starts to burn.
//
// >light candles with match
// The candles are lit.
// The flames flicker wildly and appear to dance. The earth beneath your feet
// trembles, and your legs nearly buckle beneath you. The spirits cower at your
// unearthly power.
// The match has gone out.
//
// >read book
// Each word of the prayer reverberates through the hall in a deafening
// confusion. As the last word fades, a voice, loud and commanding, speaks:
// "Begone, fiends!" A heart-stopping scream fills the cavern, and the spirits,
// sensing a greater power, flee through the walls.
//
// >drop book
// Dropped.
//
// >go south
// Land of the Dead
// You have entered the Land of the Living Dead. Thousands of lost souls can be
// heard weeping and moaning. In the corner are stacked the remains of dozens of
// previous adventurers less fortunate than yourself. A passage exits to the
// north.
// Lying in one corner of the room is a beautifully carved crystal skull. It
// appears to be grinning at you rather nastily.
//
// >take skull
// Taken.
//
// >go north
// Entrance to Hades
// There is a black book here.
// On the ground is a red hot bell.
//
// >go up
// Cave
// A gust of wind blows out your candles!
//
// >go north
// Mirror Room
// You are in a large square room with tall ceilings. On the south wall is an
// enormous mirror which fills the entire wall. There are exits on the other
// three sides of the room.
//
// >rub mirror
// There is a rumble from deep within the earth and the room shakes.
//
// >go north
// Cold Passage
// This is a cold and damp corridor where a long east-west passageway turns into
// a southward path.
//
// >go west
// Slide Room
// This is a small chamber, which appears to have been part of a coal mine. On
// the south wall of the chamber the letters "Granite Wall" are etched in the
// rock. To the east is a long passage, and there is a steep metal slide
// twisting downward. To the north is a small opening.
//
// >go north
// Mine Entrance
// You are standing at the entrance of what might have been a coal mine. The
// shaft enters the west wall, and there is another exit on the south end of the
// room.
//
// >go west
// Squeaky Room
// You are in a small room. Strange squeaky sounds may be heard coming from the
// passage at the north end. You may also escape to the east.
//
// >inventory
// You are carrying:
// A crystal skull
// A pair of candles
// A torch (providing light)
// A screwdriver
// A matchbook
// A clove of garlic
// A brass lantern
//
// >go north
// Bat Room
// You are in a small room which has doors only to the east and south.
// In the corner of the room on the ceiling is a large vampire bat who is
// obviously deranged and holding his nose.
// There is an exquisite jade figurine here.
//
// >go east
// Shaft Room
// This is a large room, in the middle of which is a small shaft descending
// through the floor into darkness below. To the west and the north are exits
// from this room. Constructed over the top of the shaft is a metal framework to
// which a heavy iron chain is attached.
// At the end of the chain is a basket.
//
// >put torch in basket
// Done.
//
// >put screwdriver in basket
// Done.
//
//
// >turn on lamp
// The brass lantern is now on.
//
// >go north
// Smelly Room
// This is a small non-descript room. However, from the direction of a small
// descending staircase a foul odor can be detected. To the south is a narrow
// tunnel.
//
// >go down
// Gas Room
// This is a small room which smells strongly of coal gas. There is a short
// climb up some stairs and a narrow tunnel leading east.
// There is a sapphire-encrusted bracelet here.
//
// >go east
// Coal Mine
// This is a non-descript part of a coal mine.
//
// >go northeast
// Coal Mine
// This is a non-descript part of a coal mine.
//
// >go southeast
// Coal Mine
// This is a non-descript part of a coal mine.
//
// >go southwest
// Coal Mine
// This is a non-descript part of a coal mine.
//
// >go down
// Ladder Top
// This is a very small room. In the corner is a rickety wooden ladder, leading
// downward. It might be safe to descend. There is also a staircase leading
// upward.
//
// >go down
// Ladder Bottom
// This is a rather wide room. On one side is the bottom of a narrow wooden
// ladder. To the west and the south are passages leaving the room.
//
// >go south
// Dead End
// You have come to a dead end in the mine.
// There is a small pile of coal here.
//
// >take coal
// Taken.
//
// >go north
// Ladder Bottom
//
// >go up
// Ladder Top
//
// >go up
// Coal Mine
//
// >go north
// Coal Mine
//
// >go east
// Coal Mine
//
// >go south
// Coal Mine
//
// >go north
// Gas Room
// There is a sapphire-encrusted bracelet here.
//
// >go up
// Smelly Room
//
// >go south
// Shaft Room
// At the end of the chain is a basket.
// The basket contains:
// A screwdriver
// A torch (providing light)
//
// >put coal in basket
// Done.
//
// >lower basket
// The basket is lowered to the bottom of the shaft.
//
// >go north
// Smelly Room
//
// >go down
// Gas Room
// There is a sapphire-encrusted bracelet here.
//
// >go east
// Coal Mine
//
// >go northeast
// Coal Mine
//
// >go southeast
// Coal Mine
//
// >go southwest
// Coal Mine
//
// >go down
// Ladder Top
//
// >go down
// Ladder Bottom
//
// >go west
// Timber Room
// This is a long and narrow passage, which is cluttered with broken timbers. A
// wide passage comes from the east and turns at the west end of the room into a
// very narrow passageway. From the west comes a strong draft.
// There is a broken timber here.
//
// >drop all
// crystal skull: Dropped.
// pair of candles: Dropped.
// matchbook: Dropped.
// clove of garlic: Dropped.
// brass lantern: Dropped.
//
// >go west
// Drafty Room
// This is a small drafty room in which is the bottom of a long shaft. To the
// south is a passageway and to the east a very narrow passage. In the shaft can
// be seen a heavy iron chain.
// At the end of the chain is a basket.
// The basket contains:
// A small pile of coal
// A screwdriver
// A torch (providing light)
//
// >take coal
// Taken.
//
// >take screwdriver
// Taken.
//
// >take torch
// Taken.
//
// >go south
// Machine Room
// This is a large, cold room whose sole exit is to the north. In one corner
// there is a machine which is reminiscent of a clothes dryer. On its face is a
// switch which is labelled "START". The switch does not appear to be
// manipulable by any human hand (unless the fingers are about 1/16 by 1/4
// inch). On the front of the machine is a large lid, which is closed.
//
// >open lid
// The lid opens.
//
// >put coal in machine
// Done.
//
// >close lid
// The lid closes.
//
// >turn switch with screwdriver
// The machine comes to life (figuratively) with a dazzling display of colored
// lights and bizarre noises. After a few moments, the excitement abates.
//
// >drop screwdriver
// Dropped.
//
// >open lid
// The lid opens, revealing a huge diamond.
//
// >take diamond
// Taken.
//
// >go north
// Drafty Room
// At the end of the chain is a basket.
//
// >put torch in basket
// Done.
//
// >put diamond in basket
// Done.
//
// >go east
// Timber Room
// There is a brass lantern (battery-powered) here.
// There is a clove of garlic here.
// There is a matchbook whose cover says "Visit Beautiful FCD#3" here.
// There is a pair of candles here.
// There is a crystal skull here.
// There is a broken timber here.
//
// >take skull
// Taken.
//
// >take lamp
// Taken.
//
// >take garlic
// Taken.
//
// >go east
// Ladder Bottom
//
// >go up
// Ladder Top
//
// >go up
// Coal Mine
//
// >go north
// Coal Mine
// A seedy-looking individual with a large bag just wandered through the room.
// On the way through, he quietly abstracted some valuables from the room and
// from your possession, mumbling something about "Doing unto others before..."
//
// >go east
// Coal Mine
//
// >go south
// Coal Mine
// A "lean and hungry" gentleman just wandered through, carrying a large bag.
// Finding nothing of value, he left disgruntled.
//
// >go north
// Gas Room
// There is a sapphire-encrusted bracelet here.
//
// >take bracelet
// Taken.
//
// >go up
// Smelly Room
//
// >go south
// Shaft Room
// From the chain is suspended a basket.
//
// >raise basket
// The basket is raised to the top of the shaft.
//
// >look in basket
// The basket contains:
// A huge diamond
// A torch (providing light)
//
// >take diamond
// Taken.
//
// >take torch
// Taken.
//
// >turn off lamp
// The brass lantern is now off.
//
// >go west
// Bat Room
// In the corner of the room on the ceiling is a large vampire bat who is
// obviously deranged and holding his nose.
// There is an exquisite jade figurine here.
//
// >take jade
// Taken.
//
// >go south
// Squeaky Room
//
// >go east
// Mine Entrance
//
// >go south
// Slide Room
//
// >go down
// Cellar
//
// >go up
// Living Room
// There is a nasty knife here.
// Your collection of treasures consists of:
// A sceptre
// A pot of gold
// A gold coffin
// A painting
//
// >inventory
// You are carrying:
// A jade figurine
// A torch (providing light)
// A huge diamond
// A clove of garlic
// A brass lantern
//
// >put jade in case
// Done.
//
// >put diamond in case
// Done.
//
// >turn on lamp
// The brass lantern is now on.
//
// >go down
// Cellar
//
// >go north
// The Troll Room
// There is a sword here.
// There is a bloody axe here.
//
// >go east
// East-West Passage
//
// >go north
// Chasm
//
// >go northeast
// Reservoir South
// You are in a long room, to the north of which was formerly a lake. However,
// with the water level lowered, there is merely a wide stream running through
// the center of the room.
// There is a path along the stream to the east or west, a steep pathway
// climbing southwest along the edge of a chasm, and a path leading into a
// canyon to the southeast.
//
// >go north
// Reservoir
// You are on what used to be a large lake, but which is now a large mud pile.
// There are "shores" to the north and south.
// Lying half buried in the mud is an old trunk, bulging with jewels.
//
// >take trunk
// Taken.
//
// >go north
// Reservoir North
// You are in a large cavernous room, the south of which was formerly a lake.
// However, with the water level lowered, there is merely a wide stream running
// through there.
// There is a slimy stairway leaving the room to the north.
// There is a hand-held air pump here.
//
// >take pump
// Taken.
//
// >take pump
// Taken.
//
// >go north
// Atlantis Room
// This is an ancient room, long under water. There is an exit to the south and
// a staircase leading up.
// On the shore lies Poseidon's own crystal trident.
//
// >take trident
// Your load is too heavy.
//
// >inventory
// You are carrying:
// A hand-held air pump
// A trunk of jewels
// A torch (providing light)
// A clove of garlic
// A brass lantern (providing light)
//
// >drop torch
// Dropped.
//
// >take trident
// Taken.
//
// >go south
// Reservoir North
//
// >go south
// Reservoir
//
// >go south
// Reservoir South
//
// >go east
// Dam
// There is a wrench here.
//
// >go east
// Dam Base
// You are at the base of Flood Control Dam #3, which looms above you and to the
// north. The river Frigid is flowing by here. Along the river are the White
// Cliffs which seem to form giant walls stretching from north to south along
// the shores of the river as it winds its way downstream.
// There is a folded pile of plastic here which has a small valve attached.
//
// >inflate plastic with pump
// The boat inflates and appears seaworthy.
// A tan label is lying inside the boat.
//
// >drop pump
// Dropped.
//
// >go inside boat
// You are now in the magic boat.
//
// >launch
// (magic boat)
// Frigid River, in the magic boat
// You are on the Frigid River in the vicinity of the Dam. The river flows
// quietly here. There is a landing on the west shore.
// The magic boat contains:
// A tan label
//
// >wait
// Time passes...
// The flow of the river carries you downstream.
//
// Frigid River, in the magic boat
// The river turns a corner here making it impossible to see the Dam. The White
// Cliffs loom on the east bank and large rocks prevent landing on the west.
// The magic boat contains:
// A tan label
//
// >wait
// Time passes...
//
// >wait
// Time passes...
// The flow of the river carries you downstream.
//
// Frigid River, in the magic boat
// The river is running faster here and the sound ahead appears to be that of
// rushing water. On the east shore is a sandy beach. A small area of beach can
// also be seen below the cliffs on the west shore.
// There is a red buoy here (probably a warning).
// The magic boat contains:
// A tan label
//
// >take buoy
// Taken.
//
// >go east
// The magic boat comes to a rest on the shore.
//
// Sandy Beach, in the magic boat
// You are on a large sandy beach on the east shore of the river, which is
// flowing quickly by. A path runs beside the river to the south here, and a
// passage is partially buried in sand to the northeast.
// There is a shovel here. (outside the magic boat)
// The magic boat contains:
// A tan label
//
// >leave boat
// You are on your own feet again.
//
// >take shovel
// Your load is too heavy.
//
// >drop garlic
// Dropped.
//
// >take shovel
// Your load is too heavy.
//
// >drop buoy
// Dropped.
//
// >take shovel
// Taken.
//
// >go northeast
// Sandy Cave
// This is a sand-filled cave whose exit is to the southwest.
//
// >dig
// What do you want to dig in?
//
// >sand
// (with the shovel)
// You seem to be digging a hole here.
//
// >dig sand
// (with the shovel)
// The hole is getting deeper, but that's about it.
//
// >dig sand
// (with the shovel)
// You are surrounded by a wall of sand on all sides.
//
// >dig sand
// (with the shovel)
// You can see a scarab here in the sand.
//
// >take scarab
// Taken.
//
// >drop shovel
// Dropped.
//
// >go southwest
// Sandy Beach
// There is a red buoy here.
// There is a clove of garlic here.
// There is a magic boat here.
// The magic boat contains:
// A tan label
//
// >open buoy
// Opening the red buoy reveals a large emerald.
//
// >take emerald
// Taken.
//
// >take garlic
// Taken.
//
// >go south
// Shore
// You are on the east shore of the river. The water here seems somewhat
// treacherous. A path travels from north to south here, the south end quickly
// turning around a sharp corner.
//
// >go south
// Aragain Falls
// You are at the top of Aragain Falls, an enormous waterfall with a drop of
// about 450 feet. The only path here is on the north end.
// A solid rainbow spans the falls.
//
// >cross rainbow
// End of Rainbow
//
// >turn off lamp
// The brass lantern is now off.
//
// >go southwest
// Canyon Bottom
//
// >go up
// Rocky Ledge
//
// >go up
// Canyon View
//
// >go northwest
// Clearing
//
// >go west
// Behind House
//
// >enter house
// Kitchen
// A bottle is sitting on the table.
// The glass bottle contains:
// A quantity of water
// There is a brown sack here.
// The brown sack contains:
// A lunch
//
// >go west
// Living Room
// There is a nasty knife here.
// Your collection of treasures consists of:
// A huge diamond
// A jade figurine
// A sceptre
// A pot of gold
// A gold coffin
// A painting
//
// >inventory
// You are carrying:
// A clove of garlic
// A large emerald
// A beautiful jeweled scarab
// A crystal trident
// A trunk of jewels
// A brass lantern
//
// >put emerald in case
// Done.
//
// >put scarab in case
// Done.
//
// >put trident in case
// Done.
//
// >put jewels in case
// Done.
//
// >go east
// Kitchen
// A bottle is sitting on the table.
// The glass bottle contains:
// A quantity of water
// There is a brown sack here.
// The brown sack contains:
// A lunch
//
// >go east
// Behind House
//
// >go north
// North of House
// You are facing the north side of a white house. There is no door here, and
// all the windows are boarded up. To the north a narrow path winds through the
// trees.
//
// >go north
// Forest Path
// This is a path winding through a dimly lit forest. The path heads north-south
// here. One particularly large tree with some low branches stands at the edge
// of the path.
//
// >climb tree
// Up a Tree
// You are about 10 feet above the ground nestled among some large branches. The
// nearest branch above you is above your reach.
// Beside you on the branch is a small bird's nest.
// In the bird's nest is a large egg encrusted with precious jewels, apparently
// scavenged by a childless songbird. The egg is covered with fine gold inlay,
// and ornamented in lapis lazuli and mother-of-pearl. Unlike most eggs, this
// one is hinged and closed with a delicate looking clasp. The egg appears
// extremely fragile.
//
// >take egg
// Taken.
//
// >climb down
// (down the tree)
// Forest Path
// You hear in the distance the chirping of a song bird.
//
// >go south
// North of House
//
// >go east
// Behind House
//
// >enter house
// Kitchen
// A bottle is sitting on the table.
// The glass bottle contains:
// A quantity of water
// There is a brown sack here.
// The brown sack contains:
// A lunch
//
// >go west
// Living Room
// There is a nasty knife here.
// Your collection of treasures consists of:
// A trunk of jewels
// A crystal trident
// A beautiful jeweled scarab
// A large emerald
// A huge diamond
// A jade figurine
// A sceptre
// A pot of gold
// A gold coffin
// A painting
//
// >turn on lamp
// The brass lantern is now on.
//
// >go down
// Cellar
//
// >go north
// The Troll Room
// There is a sword here.
// There is a bloody axe here.
//
// >go west
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go south
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go east
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go up
// Maze
// This is part of a maze of twisty little passages, all alike. A skeleton,
// probably the remains of a luckless adventurer, lies here.
// Beside the skeleton is a rusty knife.
// The deceased adventurer's useless lantern is here.
// There is a skeleton key here.
// An old leather bag, bulging with coins, is here.
//
// >take coins
// Taken.
//
// >take key
// Taken.
//
// >go southwest
// Maze
// This is part of a maze of twisty little passages, all alike.
// The lamp appears a bit dimmer.
//
// >go east
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go south
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go southeast
// Cyclops Room
// This room has an exit on the northwest, and a staircase leading up.
// A cyclops, who looks prepared to eat horses (much less mere adventurers),
// blocks the staircase. From his state of health, and the bloodstains on the
// walls, you gather that he is not very friendly, though he likes people.
//
// >Ulysses
// The cyclops, hearing the name of his father's deadly nemesis, flees the room
// by knocking down the wall on the east of the room.
//
// Treasure Room
// This is a large room, whose east wall is solid granite. A number of discarded
// bags, which crumble at your touch, are scattered about on the floor. There is
// an exit down a staircase.
// There is a suspicious-looking individual, holding a large bag, leaning
// against one wall. He is armed with a deadly stiletto.
// There is a silver chalice, intricately engraved, here.
// The thief attacks, and you fall back desperately.
//
// >give egg to thief
// The thief is taken aback by your unexpected generosity, but accepts the
// jewel-encrusted egg and stops to admire its beauty.
//
// >go down
// Cyclops Room
//
// >go east
// Strange Passage
// This is a long passage. To the west is one entrance. On the east there is an
// old wooden door, with a large opening in it (about cyclops sized).
//
// >go east
// Living Room
// There is a nasty knife here.
// Your collection of treasures consists of:
// A trunk of jewels
// A crystal trident
// A beautiful jeweled scarab
// A large emerald
// A huge diamond
// A jade figurine
// A sceptre
// A pot of gold
// A gold coffin
// A painting
//
// >put coins in case
// Done.
//
// >take knife
// Taken.
//
// >go west
// Strange Passage
//
// >go west
// Cyclops Room
//
// >go up
// You hear a scream of anguish as you violate the robber's hideaway. Using
// passages unknown to you, he rushes to its defense.
// The thief gestures mysteriously, and the treasures in the room suddenly
// vanish.
//
// Treasure Room
// There is a suspicious-looking individual, holding a large bag, leaning
// against one wall. He is armed with a deadly stiletto.
// There is a silver chalice, intricately engraved, here.
// You dodge as the thief comes in low.
//
// >kill thief with knife
// The thief is disarmed by a subtle feint past his guard.
// The robber, somewhat surprised at this turn of events, nimbly retrieves his
// stiletto.
//
// >kill thief with knife
// You dodge as the thief comes in low.
//
// >kill thief with knife
// It's curtains for the thief as your nasty knife removes his head.
// Almost as soon as the thief breathes his last breath, a cloud of sinister
// black fog envelops him, and when the fog lifts, the carcass has disappeared.
// As the thief dies, the power of his magic decreases, and his treasures
// reappear:
// A stiletto
// A jewel-encrusted egg, with a golden clockwork canary
// A torch
// A crystal skull
// A sapphire-encrusted bracelet
// The chalice is now safe to take.
//
// >take all
// stiletto: Taken.
// jewel-encrusted egg: Taken.
// torch: Taken.
// crystal skull: Taken.
// sapphire-encrusted bracelet: Taken.
// chalice: Your load is too heavy.
//
// >drop stiletto
// Dropped.
//
// >take chalice
// You're holding too many things already!
//
// >drop torch
// Dropped.
//
// >take chalice
// Taken.
//
// >go down
// Cyclops Room
//
// >go northwest
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go south
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go west
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go up
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go down
// You won't be able to get back up to the tunnel you are going through when it
// gets to the next room.
//
// Maze
// This is part of a maze of twisty little passages, all alike.
//
// >go northeast
// Grating Room
// You are in a small room near the maze. There are twisty passages in the
// immediate vicinity.
// Above you is a grating locked with a skull-and-crossbones lock.
//
// >unlock grate
// (with the skeleton key)
// The grate is unlocked.
//
// >open grate
// The grating opens to reveal trees above you.
// A pile of leaves falls onto your head and to the ground.
//
// >go up
// Clearing
// You are in a clearing, with a forest surrounding you on all sides. A path
// leads south.
// There is an open grating, descending into darkness.
//
// >go south
// Forest Path
// You hear in the distance the chirping of a song bird.
//
// >climb tree
// Up a Tree
// Beside you on the branch is a small bird's nest.
// You hear in the distance the chirping of a song bird.
//
// >wind up canary
// The canary chirps, slightly off-key, an aria from a forgotten opera. From out
// of the greenery flies a lovely songbird. It perches on a limb just over your
// head and opens its beak to sing. As it does so a beautiful brass bauble drops
// from its mouth, bounces off the top of your head, and lands glimmering in the
// grass. As the canary winds down, the songbird flies away.
//
// >go down
// Forest Path
// There is a beautiful brass bauble here.
//
// >take bauble
// You're holding too many things already!
//
// >drop knife
// Dropped.
// You hear in the distance the chirping of a song bird.
//
// >take bauble
// Taken.
//
// >go south
// North of House
//
// >go east
// Behind House
//
// >enter house
// Kitchen
// A bottle is sitting on the table.
// The glass bottle contains:
// A quantity of water
// There is a brown sack here.
// The brown sack contains:
// A lunch
//
// >go west
// Living Room
// Your collection of treasures consists of:
// A leather bag of coins
// A trunk of jewels
// A crystal trident
// A beautiful jeweled scarab
// A large emerald
// A huge diamond
// A jade figurine
// A sceptre
// A pot of gold
// A gold coffin
// A painting
//
// >put bauble in case
// Done.
//
// >put chalice in case
// Done.
//
// >take canary from egg
// Taken.
//
// >put canary in case
// Done.
//
// >put egg in case
// Done.
//
// >put bracelet in case
// Done.
//
// >put skull in case
// Done.
//
// >go down
// Cellar
//
// >go north
// The Troll Room
// There is a sword here.
// There is a bloody axe here.
//
// >go east
// East-West Passage
//
// >go east
// Round Room
//
// >go east
// Loud Room
// This is a large room with a ceiling which cannot be detected from the ground.
// There is a narrow passage from east to west and a stone stairway leading
// upward. The room is deafeningly loud with an undetermined rushing sound. The
// sound seems to reverberate from all of the walls, making it difficult even to
// think.
// On the ground is a large platinum bar.
//
// >echo
// The acoustics of the room change subtly.
//
// Loud Room
// On the ground is a large platinum bar.
//
// >take bar
// Taken.
//
// >go west
// Round Room
//
// >go west
// East-West Passage
//
// >go west
// The Troll Room
// There is a sword here.
// There is a bloody axe here.
//
// >go south
// Cellar
//
// >go up
// Living Room
// Your collection of treasures consists of:
// A crystal skull
// A sapphire-encrusted bracelet
// A jewel-encrusted egg
// A golden clockwork canary
// A chalice
// A beautiful brass bauble
// A leather bag of coins
// A trunk of jewels
// A crystal trident
// A beautiful jeweled scarab
// A large emerald
// A huge diamond
// A jade figurine
// A sceptre
// A pot of gold
// A gold coffin
// A painting
//
// >put bar in case
// Done.
//
// Points: 349