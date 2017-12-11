using System;

namespace funcProg_codeNight
{
    public class DateComparer
    {
        public int DaysSince(DateTime from)
            => (DateTime.Now - from).Days;

        public int DaysSincePure(DateTime from, DateTime now)
            => (now - from).Days;
    }
}