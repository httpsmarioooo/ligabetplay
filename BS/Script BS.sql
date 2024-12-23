create table public.coaches (
  id serial primary key,
  name text not null
);

create table public.stadiums (
  id serial primary key,
  name text not null,
  location text not null,
  capacity int not null
);

create table public.teams (
  id serial primary key,
  name text not null,
  stadium_id integer references stadiums (id),
  coach_id integer references coaches (id)
);

create table public.event_type (
  id serial primary key,
  name text not null
);

create table public.judge_roles (
  id serial primary key,
  role_name text not null
);

create table public.judges (
  id serial primary key,
  name text not null,
  role_id integer references judge_roles (id)
);

create table public.players (
  id serial primary key,
  name text not null,
  team_id integer references teams (id),
  "position" text not null
);

create table public.matches (
  id serial primary key,
  home_team_id integer references teams (id),
  away_team_id integer references teams (id),
  stadium_id integer references stadiums (id),
  match_date timestamp not null
);

create table public.goals (
  id serial primary key,
  match_id integer references matches (id),
  player_id integer references players (id),
  minute int not null
);

create table public.assists (
  id serial primary key,
  match_id integer references matches (id),
  player_id integer references players (id),
  goal_id integer references goals (id)
);

create table public.standings (
  id serial primary key,
  team_id integer references teams (id),
  matches_played int not null,
  wins int not null,
  draws int not null,
  losses int not null,
  points int not null
);

create table public.match_events (
  id serial primary key,
  match_id integer references matches (id),
  event_type_id integer references event_type (id),
  player_id integer references players (id),
  minute int not null
);

create table public.judges_per_match (
  id serial primary key,
  match_id integer references matches (id),
  judge_id integer references judges (id)
);
