package com.abhinav.fable.data

import com.abhinav.fable.R
import kotlinx.coroutines.delay

class StoryRepository {

    //Error Handling
    suspend fun fetchStories(): Result<List<Story>> {
        return try {
            delay(1000)

            Result.success(mockStories)
        } catch (e: Exception) {
            Result.failure(e)
        }
        }


    // Mock, local data for stories
    companion object {
        val mockStories = listOf(
            Story(
                id = 1,
                title = "The Secret of the Whispering Wood",
                author = "Lyra Rivers",
                readTime = "10 min",
                category = "FANTASY",
                description = "A young cartographer ventures into an uncharted forest where the trees hold the memories of a lost civilization.",
                content = listOf(
                    "Elara adjusted the leather straps of her satchel, the worn parchment maps inside crinkling softly. Before her stood the Whispering Wood, a dense expanse of ancient ash and silver birch that no cartographer in the kingdom of Aethelgard had ever successfully mapped. The locals said the trees didn't just grow; they remembered. They breathed the forgotten histories of a world that existed before the Great Sundering.",

                    "She stepped over the threshold of twisted roots, instantly feeling a shift in the air. The harsh midday sun was filtered into a cool, bioluminescent twilight. The leaves above shimmered with a faint, iridescent glow, casting long, dancing shadows on the mossy floor. The silence was absolute, yet the air buzzed with a static energy, like the moment right before a lightning strike.",

                    "According to the royal archives, the Whispering Wood was the last known location of the Sunken Spire, an observatory built by the first mages. Elara's compass, a brass instrument enchanted to point toward strong magical currents, spun wildly in her palm before settling on a direction that shifted every few paces. She realized with a cold thrill that the forest was intentionally leading her astray, testing her resolve.",

                    "As she pressed deeper, the trunks of the trees began to change. The bark grew smooth and pale, etched with naturally occurring runes that glowed faintly with a sapphire light. When she reached out to brush her fingertips against one of the glyphs, a rush of images flooded her mind. She saw a city of glass and gold, people with eyes like starlight, and a great cataclysm of falling fire. The tree was sharing its memory, speaking directly into her consciousness.",

                    "She documented everything, her quill scratching frantically across her journal. The stories weren't just myths; the forest was a living library. But the deeper she went, the more sorrowful the memories became. The trees wept sap that looked like liquid silver, mourning the civilization they had failed to protect during the ancient wars.",

                    "Suddenly, the dense canopy parted, revealing a massive clearing. In the center, half-buried in centuries of overgrowth, stood the Sunken Spire. It wasn't ruined; it was dormant. At its base lay a crystalline pedestal holding a single, uncorrupted seed—the progenitor of the wood. Elara understood then that she wasn't sent here just to map the forest. She was meant to witness its history and carry the truth back to a world that had forgotten its roots.",

                    "She carefully sketched the spire, the seed, and the glowing runes. The Whispering Wood had finally allowed itself to be mapped, not as a physical location, but as a testament to endurance. When Elara finally turned back toward the edge of the forest, the trees seemed to part for her, their whispers turning into a gentle, guiding breeze that carried her safely home."
                ),
                coverImages = R.drawable.forest

            ),
            Story(
                id = 2,
                title = "The Enchanted Garden",
                author = "Lyra Rivers",
                readTime = "20 min",
                category = "FANTASY",
                description = "A young botanist unlocks a sealed courtyard, discovering a forgotten ecosystem where flora defies the laws of nature.",
                content = listOf(
                    "The iron gates to the grand estate’s central courtyard had been sealed for centuries, choked by thick, thorny vines that seemed to pulse with a faint, bioluminescent glow in the moonlight. Elian, a botanist obsessed with ancient myths, spent three weeks deciphering the runic lock mechanism.",
                    "When the heavy doors finally groaned open, they revealed a world that defied every textbook Elian had ever studied. Flowers with petals made of spun glass chimed softly in the gentle breeze, and a small, winding brook of liquid silver wove through carpets of luminescent blue moss.",
                    "He stepped cautiously inside, his leather-bound journal trembling in his hands. Every step he took caused the flora to react; crystalline orchids turned their heads to follow his movements, and enormous ferns uncurled their fronds to offer glowing, amber-colored berries.",
                    "But the true marvel lay at the very center of the overgrown garden. A colossal weeping willow, its branches dripping with what looked like captured starlight, housed a presence much older than the dirt itself. As Elian approached, the leaves rustled, whispering his name and welcoming the first human to enter the sanctuary in a thousand years."
                ),
                coverImages = R.drawable.keeper
            ),
            Story(
                id = 3,
                title = "The Neon Horizon",
                author = "Jonah",
                readTime = "8 min",
                category = "SCI-FI",
                description = "A lone engineer aboard a deep-space station discovers a signal that wasn't meant for human ears.",
                content = listOf(
                    "The hum of the environmental scrubbers was the only company Elara had known for the past three hundred cycles. Station Kaelen-9 was an observation post, a tiny metallic speck orbiting a gas giant at the very edge of the recognized sector. It was a quiet posting, meant for monitoring gravitational anomalies and solar flares. It was not meant for first contact.",
                    "It started as a blip. A micro-fluctuation in the long-range telemetry sensors that Elara initially dismissed as cosmic dust striking the outer hull. But the blip repeated. It was rhythmic, structured, and entirely too perfect to be born of natural celestial mechanics. She pulled up the raw data on her primary console, the neon blue glow of the screens reflecting in her tired eyes.",
                    "She ran it through the standard decryption algorithms. Nothing. She ran it through the complex quantum filters. Still nothing. The signal wasn't encrypted; it was just incredibly dense. It was a language, mathematics, and a localized star map all woven into a single, repeating frequency.",
                    "'Computer, isolate the origin of this transmission,' Elara commanded, her voice raspy from disuse. The console trilled softly, and a holographic projection of the sector illuminated the center of the cramped command deck. A red marker blinked off the edge of the charted map, deep within the Void.",
                    "The realization hit her like a physical blow. The signal wasn't coming from outside the sector. It was coming from a dark matter nebula that every automated probe had failed to return from. And it was getting closer.",
                    "Elara initiated the station's recording protocols. She knew the standard operating procedure was to bounce the signal back to Central Command, wait for authorization, and remain in stealth mode. But the signal changed. The rhythmic pulse shifted, forming what sounded eerily like a harmonic chord, followed by a sudden, deafening silence.",
                    "The proximity alarms screamed to life. The massive reinforced viewport at the front of the command deck, usually filled with the swirling orange storms of the gas giant, suddenly went pitch black. Something massive, something that consumed light itself, had just positioned itself between the station and the planet.",
                    "Elara’s fingers flew across the console, transferring all power to the communication arrays. She didn't know what was outside, but she knew humanity needed to hear this. As the station's hull began to groan under a sudden, localized gravitational shift, she slammed the broadcast button, sending the dense, alien signal into the heart of human territory.",
                    "The lights flickered, then died, plunging the station into darkness. Only the emergency backup neon strips remained, casting long, eerie shadows. Elara unbuckled her harness and floated toward the viewport, placing a trembling hand on the cold glass. She wasn't alone anymore."
                ),
                coverImages = R.drawable.neon
            ),
            Story(
                id = 4,
                title = "The Midnight Echo",
                author = "Author 4",
                readTime = "40 min",
                category = "MYSTERY",
                description = "A seasoned detective investigates a locked-room disappearance where the only witness is a broken grandfather clock.",
                content = listOf(
                    "Detective Miller stood in the center of the mahogany study, the silence of the room broken only by the rhythmic ticking of the antique grandfather clock in the corner. Mr. Blackwood had vanished entirely, leaving behind nothing but an overturned chair and a half-empty glass of scotch on the desk.",
                    "Miller had seen his fair share of locked-room mysteries, but this one defied all logic. The heavy oak doors were bolted from the inside. The windows were sealed tight, having been painted shut years ago. Yet, a man had seemingly evaporated into thin air right before his midnight nightcap.",
                    "He approached the towering clock, its heavy brass pendulum swinging with hypnotic precision. The estate staff had sworn up and down that the clock hadn't chimed in over a decade, its internal gears long since stripped and rusted. But as Miller knelt to inspect the carved wooden casing, he noticed a fresh, distinct scuff mark on the dusty floorboards directly beneath it.",
                    "With a heavy heave, Miller pushed the massive timepiece to the side. The wall behind it wasn't solid plaster; it was a hollow wooden panel left slightly ajar, revealing a narrow, pitch-black corridor hidden within the architecture of the house. The clock wasn't just a vintage decoration; it was a concealed door.",
                    "Drawing his flashlight, Miller stepped into the stagnant air of the darkness. The real mystery of the Blackwood estate wasn't how the victim had left the room, but exactly where this hidden passage was about to take him."
                ),
                coverImages = R.drawable.keeper
            ),
            Story(
                id = 5,
                title = "The Lighthouse",
                author = "Author 5",
                readTime = "50 min",
                category = "Fantasy",
                description = "A keeper at the edge of the world guides ships not across the sea, but through the treacherous currents of the astral plane.",
                content = listOf(
                    "The Keeper's tower sat on a jagged promontory where the ocean of water abruptly met the ocean of stars. This was the edge of the known world, a place where gravity lost its grip and the horizon folded upward into an endless twilight.",
                    "Silas did not burn whale oil or kerosene to keep the great lamp turning. Instead, he fed the brass furnace with captured stardust and the crystallized echoes of old sea shanties. The light it produced was a piercing, ethereal silver that could cut through the thickest dimensional fog.",
                    "Tonight, the fog was rolling in thick, smelling of ozone and forgotten memories. Silas tightened his heavy wool coat and adjusted his brass telescope. Out in the swirling void, a vessel was approaching. It wasn't made of timber and sailcloth, but of woven light and the sheer willpower of its astral navigators.",
                    "The cosmic reefs hidden in the fog were treacherous, known to shatter souls and scatter them across the galaxy. Silas cranked the heavy iron gears, intensifying the beam. He cast a perfectly straight line of silver light over the dangerous shoals, holding his breath as the ethereal ship caught the beam and surfed it safely into the harbor of reality."
                ),
                coverImages = R.drawable.keeper
            ),
            Story(
                id = 6,
                title = "Echoes of Earth",
                author = "H.G. Wells",
                readTime = "22 min",
                category = "SCI-FI",
                description = "Generations after abandoning a ruined Earth, a colony ship receives a transmission from their dead homeworld.",
                content = listOf(
                    "The generation ship 'Aethelgard' had been coasting through the interstellar void for three hundred years. To the millions of souls asleep in cryo-stasis, and the skeleton crew awake to monitor them, Earth was nothing more than a mythological cautionary tale—a blue pearl choked by ash.",
                    "Commander Elias was drinking synthetic coffee on the observation deck when the comms panel lit up. It wasn't a standard telemetry ping from a navigational beacon. It was an audio file. An archaic, low-frequency radio burst that the ship's computer almost filtered out as cosmic radiation.",
                    "Elias routed the audio to the main speakers. Through a thick wall of static, a voice broke through. It was human. It was speaking a dialect of English that hadn't been used in centuries.",
                    "'This is Outpost Seven. The skies are clearing. Repeat, the atmospheric scrubbers hold. We have blue skies. If anyone is out there... it's time to come home.'"
                ),
                coverImages = R.drawable.echoes
            ),
            Story(
                id = 7,
                title = "The Canvas of Time",
                author = "Leonardo DaVinci",
                readTime = "18 min",
                category = "DRAMA",
                description = "An art restorer working on a Renaissance masterpiece discovers a hidden layer meant explicitly for her.",
                content = listOf(
                    "Elena adjusted her magnifying visor, her hand steady as she applied the mild solvent to the corner of the 16th-century portrait. The painting, an uncredited depiction of a Florentine noblewoman, had been stored in the Vatican archives for centuries.",
                    "As decades of grime and aged varnish dissolved beneath her cotton swab, Elena noticed an anomaly. The brushstrokes beneath the surface didn't match the top layer. There was text hidden in the folds of the noblewoman's painted gown.",
                    "Switching to an ultraviolet light, Elena leaned in close. The hidden pigment illuminated, glowing a faint, ethereal green. It wasn't just a signature or a date. It was a letter, written in perfect, modern Italian.",
                    "'To Elena,' the inscription read. 'If you have found this, then the restoration was successful. Do not trust the museum director with the artifact in the silver vault. He knows what it does.'"
                ),
                coverImages = R.drawable.canvas
            ),
            Story(
                id = 8,
                title = "The Whispering Woods",
                author = "J.R.R. Tolkien",
                readTime = "28 min",
                category = "FANTASY",
                description = "A young herbalist wanders off the beaten path and finds a forest that remembers every secret ever spoken.",
                content = listOf(
                    "The locals always warned travelers to stay on the cobblestone path when passing through the Elderwood. They said the trees were old, and old things tend to get hungry. But Lyra needed ghost-fern, and ghost-fern only grew in the deep shade.",
                    "She stepped off the stones. The ambient sound of the forest immediately shifted. The chirping of crickets ceased, replaced by a low, rhythmic hum that seemed to vibrate through the soles of her boots.",
                    "As she knelt to harvest a patch of ferns, a voice whispered directly into her right ear. It was her mother's voice, though her mother had been dead for ten years. 'Don't trust the King's guard, little bird.'",
                    "Lyra spun around, drawing her small harvesting knife. There was no one there. But the bark of the nearest oak tree was shifting, its knots twisting into the shape of a sorrowful face."
                ),
                coverImages = R.drawable.forest
            ),
            Story(
                id = 9,
                title = "The Clockwork King",
                author = "Mary Shelley",
                readTime = "32 min",
                category = "SCI-FI",
                description = "In a steampunk metropolis, a rogue mechanic is tasked with repairing the automaton that rules the city.",
                content = listOf(
                    "The throne room smelled of ozone and hot brass. Silas wiped a smear of grease from his goggles and stared up at the Sovereign. It was a towering marvel of gears and steam-pipes, designed to rule the city with perfect, unfeeling logic.",
                    "But the Sovereign was broken. For three days, it had issued erratic commands, shutting down power grids and deploying the brass-guard to empty sectors of the city. Silas had been brought in quietly to fix it before the populace panicked.",
                    "He popped the main chassis open. The intricate clockwork heart was spinning furiously. But as Silas reached in with his wrench, he noticed something horrifying wedged between the primary cognitive gears.",
                    "It wasn't a broken spring or a jammed piston. It was a piece of organic matter. A human heart, beating in perfect synchronization with the machinery."
                ),
                coverImages = R.drawable.clocktower
            ),
            Story(
                id = 10,
                title = "The Silent Witness",
                author = "Raymond Chandler",
                readTime = "45 min",
                category = "MYSTERY",
                description = "A private eye interrogates the only survivor of a diamond heist: a highly intelligent parrot.",
                content = listOf(
                    "The office was empty except for a large brass cage sitting on the desk. Inside, a Blue Macaw named 'Captain' stared at Detective Vance with cold, calculating eyes. Captain was the only living thing found inside the vault after the Van Der Linde diamonds vanished.",
                    "Vance tapped his pen against his notepad. 'Alright, bird. Let's try this again. Who opened the safe?'",
                    "The parrot ruffled its feathers, tilted its head, and perfectly mimicked the sound of a heavy steel door vaulting open. Then, it spoke in a raspy, distinctly human baritone: 'Cut the wires, Jimmy. Cut the wires.'",
                    "Vance froze. He knew that voice. It belonged to the precinct's very own Chief of Police. The heist wasn't an outside job; it was orchestrated from the top down. And the only thing keeping Vance alive right now was the fact that the Chief didn't know the bird could talk."
                ),
                coverImages = R.drawable.silence
            )

        )
    }
}