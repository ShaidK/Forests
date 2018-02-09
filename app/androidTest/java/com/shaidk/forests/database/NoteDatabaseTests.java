/*
 * File: NoteDatabaseTests.java | Note: Maintains the tests associated with the NoteDatabase class
 */

/*
 * MIT License
 *
 * Copyright (c) 2017 Shaid Khan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.shaidk.forests.database;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.filters.MediumTest;
import android.arch.persistence.room.Room;

import com.shaidk.forests.database.entities.Note;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class NoteDatabaseTests
{
    @Test
    public void Given_Multiple_Notes__When__Storing_The_Notes_Within_The_Database__Then__Confirm_The_Notes_Are_Stored() {
        this.obtainNoteDatabase.obtainNoteDao().insertNewNote(new Note(), new Note(), new Note());
        assertEquals(this.obtainNoteDatabase.obtainNoteDao().obtainAllNotes().size(), 3);
    }

    @Before
    public void initialiseNoteDatabase() {
        this.obtainNoteDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getTargetContext(),
                NoteDatabase.class).build();
    }

    @After
    public void closeNoteDatabase() {
        this.obtainNoteDatabase.close();
    }

    private NoteDatabase obtainNoteDatabase;
}